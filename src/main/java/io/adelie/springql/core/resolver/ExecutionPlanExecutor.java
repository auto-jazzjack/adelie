package io.adelie.springql.core.resolver;

import io.adelie.springql.model.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


        Condition condition = executionPlan.getCondition();


        Mono<Object> generate = executionPlan.getMySelf().generate(condition);

        Mono<Map<Resolver, Object>> aggregated = Flux.fromIterable(executionPlan.getNext().entrySet())
                .flatMap(i -> {
                    return this.exec(i.getValue()).map(j -> Pair.of(i.getValue().getMySelf(), j));
                })
                .collectList()
                .map(this::aggregateByResolver);

        /*Mono<Map<Resolver, Object>> aggregated = generate
                .flatMapMany(i -> {
                    return Flux.fromIterable(executionPlan.getNext().entrySet())
                            .flatMap(j -> {
                                if (condition.getRoot() == null) {
                                    condition.setRoot(Condition.KeyValue.of(null, i, Resolver.DataType.SINGLE));
                                }
                                updateCondition(executionPlan.getMySelf(), condition, null, i);
                                return this.exec(j.getValue()).map(k -> Pair.of(j.getValue().getMySelf(), k));
                            });
                })
                .collectList()
                .map(this::aggregateByResolver);*/

        return Mono.zip(generate, aggregated)
                .map(i -> {
                    T t1 = (T) i.getT1();
                    i.getT2().entrySet().forEach(j -> j.getKey().setData(t1, j.getValue()));
                    return t1;
                });
    }


    private Map<Resolver, Object> aggregateByResolver(List<Pair<Resolver, Object>> list) {
        Map<Resolver, Object> retv = new HashMap<>();

        for (Pair<Resolver, Object> j : list) {
            retv.put(j.getKey(), j.getValue());
        }
        return retv;

    }

}
