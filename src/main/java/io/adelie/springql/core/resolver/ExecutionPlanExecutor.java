package io.adelie.springql.core.resolver;

import io.adelie.springql.model.Pair;
import io.adelie.springql.model.Triple;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Input) execution plan
 * Output)
 */
@Component
public class ExecutionPlanExecutor {

    public <T> Mono<T> exec(ExecutionPlan executionPlan, T root) {
        return this.exec(executionPlan, DataFetchingEnv.KeyValue.of(null, root));
    }

    private <T> Mono<T> exec(ExecutionPlan executionPlan, DataFetchingEnv.KeyValue root) {
        executionPlan.getDataFetchingEnv().setRoot(root);
        return this.exec(executionPlan);
    }


    public <T> Mono<T> exec(ExecutionPlan executionPlan) {
        if (executionPlan == null) {
            return Mono.empty();
        }

        if (CollectionUtils.isEmpty(executionPlan.getNext())) {
            return (Mono<T>) executionPlan.generateMySelf();
        }

        Mono<Object> generate = executionPlan.generateMySelf().cache();

        Mono<Map<Object, Pair<Resolver, Object>>> collect = generate.flatMapMany(i -> {
            if (executionPlan.getMySelf() instanceof ListResolver) {
                List<Object> result = (List<Object>) i;
                Flux<Triple<Resolver, Object, Object>> tripleFlux = Flux.empty();
                for (int k = 0; k < result.size(); k++) {
                    final int k1 = k;
                    tripleFlux = tripleFlux.concatWith(Flux.fromIterable(executionPlan.getNext().entrySet())
                            .flatMap(j -> {
                                j.getValue().getDataFetchingEnv().setNearRoot(DataFetchingEnv.KeyValue.of(k1, result.get(k1)));
                                return this.exec(j.getValue()).map(l -> Triple.of(j.getValue().getMySelf(), k1, l));
                            }));
                }
                return tripleFlux;

            } else {
                return Flux.fromIterable(executionPlan.getNext().entrySet())
                        .flatMap(j -> this.exec(j.getValue()).map(l -> Triple.of(j.getValue().getMySelf(), null, l)));
            }
        }).collect(Collectors.toMap(Triple::getMiddle, i -> Pair.of(i.getLeft(), i.getRight())));

        return Mono.zip(generate, collect)
                .map(i -> {
                    if (i.getT1() instanceof List) {
                        List<Object> t = (List<Object>) i.getT1();
                        i.getT2().entrySet()
                                .forEach(j -> {
                                    int idx = (Integer) j.getKey();
                                    j.getValue().getKey().setData(t.get(idx), j.getValue().getValue());
                                });
                    } else {
                        i.getT2().entrySet().forEach(j -> j.getValue().getKey().setData(i.getT1(), j.getValue().getValue()));
                    }

                    return (T) i.getT1();
                });

    }
}
