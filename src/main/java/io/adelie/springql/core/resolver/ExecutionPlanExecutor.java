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
                                //j.getValue().getDataFetchingEnv().setRoot(executionPlan.getDataFetchingEnv().getRoot());
                                return this.exec(j.getValue()).map(l -> Triple.of(j.getValue().getMySelf(), k1, l));
                            }));
                }
                return tripleFlux;

            } else {
                return Flux.fromIterable(executionPlan.getNext().entrySet())
                        .flatMap(j -> {
                            //j.getValue().getDataFetchingEnv().setRoot(executionPlan.getDataFetchingEnv().getRoot());
                            return this.exec(j.getValue()).map(l -> Triple.of(j.getValue().getMySelf(), null, l));
                        });
            }
        }).collect(Collectors.toMap(Triple::getMiddle, i -> Pair.of(i.getLeft(), i.getRight())));

        return Mono.zip(generate, collect)
                .map(i -> {

                    if (i.getT1() instanceof List) {
                        List<Object> t = (List<Object>) i.getT1();
                        i.getT2().forEach((key, value) -> {
                            int idx = (Integer) key;
                            value.getKey().setData(t.get(idx), value.getValue());
                        });
                    } else {
                        i.getT2().forEach((key, value) -> value.getKey().setData(i.getT1(), value.getValue()));
                    }

                    return (T) i.getT1();
                });

    }
}
