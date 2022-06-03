package io.adelie.springql.core.resolver.impl;

import io.adelie.springql.core.resolver.Condition;
import io.adelie.springql.core.resolver.Resolver;
import io.adelie.springql.model.BookStore;
import io.adelie.springql.model.SampleResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class BookStoreResolver implements Resolver<SampleResponse, List<BookStore>> {

    @Override
    public DataType getType() {
        return DataType.OBJECT;
    }

    @Override
    public Mono<List<BookStore>> generate(Condition condition) {
        return Mono.empty();
    }


}
