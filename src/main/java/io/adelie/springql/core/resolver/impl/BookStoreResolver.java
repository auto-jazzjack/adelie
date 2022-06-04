package io.adelie.springql.core.resolver.impl;

import io.adelie.springql.core.resolver.DataFetchingEnv;
import io.adelie.springql.core.resolver.ListResolver;
import io.adelie.springql.core.resolver.Resolver;
import io.adelie.springql.model.BookStore;
import io.adelie.springql.model.Pair;
import io.adelie.springql.model.SampleResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BookStoreResolver implements ListResolver<SampleResponse, List<BookStore>> {

    @Override
    public void setData(SampleResponse sampleResponse, List<BookStore> myself) {
        sampleResponse.setBookStores(myself);
    }

    @Override
    public Mono<List<BookStore>> generate(DataFetchingEnv condition) {
        return Mono.just(Stream.of(BookStore.builder()
                        .contact("123456")
                        .build(),
                BookStore.builder()
                        .contact("123456")
                        .build()
        ).collect(Collectors.toList()));
    }

    @Override
    public Map<String, Class<? extends Resolver>> next() {
        return Stream.of(Pair.of("books", BookResolver.class))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }
}
