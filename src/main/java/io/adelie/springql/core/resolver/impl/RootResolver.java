package io.adelie.springql.core.resolver.impl;

import io.adelie.springql.core.resolver.Condition;
import io.adelie.springql.core.resolver.Resolver;
import io.adelie.springql.core.resolver.SingleResolver;
import io.adelie.springql.model.Pair;
import io.adelie.springql.model.SampleResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class RootResolver implements SingleResolver<Void, SampleResponse> {

    @Override
    public void setData(Void unused, SampleResponse sampleResponse) {
        //do nothing
    }

    @Override
    public Mono<SampleResponse> generate(Condition condition) {
        return Mono.just(SampleResponse.builder()
                .time(Long.toString(System.currentTimeMillis()))
                .build());
    }

    @Override
    public Map<String, Class<? extends Resolver>> next() {
        return Stream.of(Pair.of("bookStores", BookStoreResolver.class))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }
}
