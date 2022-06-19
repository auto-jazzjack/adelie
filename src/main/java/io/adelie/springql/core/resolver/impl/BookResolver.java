package io.adelie.springql.core.resolver.impl;

import io.adelie.springql.core.resolver.DataFetchingEnv;
import io.adelie.springql.core.resolver.KeyValue;
import io.adelie.springql.core.resolver.Resolver;
import io.adelie.springql.model.Book;
import io.adelie.springql.model.BookStore;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class BookResolver implements Resolver<BookStore, List<Book>> {

    @Override
    public void setData(BookStore bookStore, List<Book> books) {
        bookStore.setBooks(books);
    }

    @Override
    public Mono<List<Book>> generate(DataFetchingEnv condition) {
        BookStore nearRoot = (BookStore)condition.getNearRoot().getValueByKey();
        return Mono.just(Stream.of(
                        Book.builder()
                                .title("hello")
                                .price(80000L)
                                .build(),
                        Book.builder()
                                .title("world")
                                .price(50000L)
                                .build()
                )
                .collect(Collectors.toList()));
    }


}
