package io.adelie.springql.core.resolver;

import io.adelie.springql.core.resolver.impl.RootResolver;
import io.adelie.springql.model.Pair;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ExecutionPlanGenerator {

    private final RootResolver rootResolver;
    private final ResolverMapper resolverMapper;

    public ExecutionPlan generate(Query query) {
        ExecutionPlan generate = generate(rootResolver, query);
        return generate;
    }

    private ExecutionPlan generate(Resolver current, Query query) {

        if (current == null) {
            return null;
        }
        ExecutionPlan executionPlan = ExecutionPlan.builder()
                .mySelf(current)
                .currFields(query.getFields())
                .build();

        //Query resolver에서 value가 not null인 케이스를 돈다
        Set<String> collect = Optional.ofNullable(query.getQueryByResolverName())
                .orElse(Collections.emptyMap())
                .entrySet()
                .stream()
                .filter(i -> i.getValue() != null)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());


        Map<String, Class<? extends Resolver>> next = current.next();
        next.entrySet()
                .stream()
                .filter(i -> collect.contains(i.getKey()))
                .map(i -> Pair.of(i.getKey(), resolverMapper.toInstant(i.getValue())))
                .forEach(i -> {
                    ExecutionPlan generate = generate(i.getValue(), query.getQueryByResolverName().get(i.getKey()));
                    executionPlan.addNext(i.getKey(), generate);
                });


        return executionPlan;
    }
}
