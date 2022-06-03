package io.adelie.springql.core.resolver;

import io.adelie.springql.model.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
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

        //base
        Mono<Object> generate = executionPlan.getMySelf().generate(condition);

        Mono<Map<Resolver, Object>> aggregated = Flux.fromIterable(executionPlan.getNext().entrySet())
                .flatMap(i -> this.exec(i.getValue()).map(j -> Pair.of(i.getValue().getMySelf(), j)))
                .collectList()
                .map(this::aggregateByResolver);


        return Mono.zip(generate, aggregated)
                .map(i -> {
                    T t1 = (T) i.getT1();
                    i.getT2().entrySet()
                            .forEach(j -> Resolver.setData(j.getKey(), t1, j.getValue()));
                    return t1;
                });
    }

    Map<Resolver, Object> aggregateByResolver(List<Pair<Resolver, Object>> list) {
        Map<Resolver, Object> retv = new HashMap<>();

        for (Pair<Resolver, Object> j : list) {
            if (j.getKey() instanceof ListResolver) {
                List<Object> res = (List<Object>) retv.computeIfAbsent(j.getKey(), (k) -> new ArrayList<>());
                res.add(j.getValue());
            } else if (j.getKey() instanceof MapResolver) {
                Map<Object, Object> res = (Map<Object, Object>) retv.computeIfAbsent(j.getKey(), (k) -> new HashMap<>());
                Pair<Object, Object> value = (Pair<Object, Object>) j.getValue();
                res.put(value.getKey(), value.getValue());
            } else {
                retv.put(j.getKey(), j.getValue());
            }
        }
        return retv;

    }

}
