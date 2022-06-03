package io.adelie.springql.core.resolver.impl;

import io.adelie.springql.core.resolver.Condition;
import io.adelie.springql.core.resolver.Resolver;
import io.adelie.springql.model.Pair;
import io.adelie.springql.model.SampleResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RootResolver implements Resolver<SampleResponse> {

    @Override
    public DataType getType() {
        return DataType.OBJECT;
    }

    @Override
    public Mono<SampleResponse> generate(Condition condition) {
        return Mono.empty();
    }

    @Override
    public Map<String, Class<? extends Resolver>> next() {
        return Stream.of(Pair.of("bookStores", BookStoreResolver.class))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }
}
