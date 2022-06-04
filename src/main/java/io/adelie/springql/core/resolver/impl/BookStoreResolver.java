package io.adelie.springql.core.resolver.impl;

import io.adelie.springql.core.resolver.Condition;
import io.adelie.springql.core.resolver.Resolver;
import io.adelie.springql.model.BookStore;
import io.adelie.springql.model.Pair;
import io.adelie.springql.model.SampleResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BookStoreResolver implements Resolver<SampleResponse, List<BookStore>> {

    @Override
    public void setData(SampleResponse sampleResponse, List<BookStore> myself) {
        sampleResponse.setBookStores(myself);
    }

    @Override
    public Mono<List<BookStore>> generate(Condition condition) {
        return Mono.just(Collections.singletonList(BookStore.builder()
                .contact("123456")
                .build()));
    }

    @Override
    public Map<String, Class<? extends Resolver>> next() {
        return Stream.of(Pair.of("books", BookResolver.class))
                .collect(Collectors.toMap(Pair::getKey, Pair::getValue));
    }
}
