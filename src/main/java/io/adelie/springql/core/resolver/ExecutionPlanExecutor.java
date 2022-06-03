package io.adelie.springql.core.resolver;

import io.adelie.springql.model.Pair;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

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

        Mono<List<Pair<Resolver, Object>>> listMono = Flux.fromIterable(executionPlan.getNext().entrySet())
                .flatMap(i -> this.exec(i.getValue()).map(j -> Pair.of(i.getValue().getMySelf(), j)))
                .collectList();

        return Mono.zip(generate, listMono)
                .map(i -> {
                    T t1 = (T) i.getT1();
                    i.getT2().stream()
                            .forEach(j -> {
                                System.out.println(j);
                                //j.getKey().setData(t1, j);
                            });
                    return t1;
                });
    }
}
