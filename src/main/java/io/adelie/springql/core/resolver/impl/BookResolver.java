package io.adelie.springql.core.resolver.impl;

import io.adelie.springql.core.resolver.Condition;
import io.adelie.springql.core.resolver.SingleResolver;
import io.adelie.springql.model.Book;
import io.adelie.springql.model.BookStore;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class BookResolver implements SingleResolver<BookStore, List<Book>> {

    @Override
    public void setData(BookStore bookStore, List<Book> books) {
        bookStore.setBooks(books);
    }

    @Override
    public Mono<List<Book>> generate(Condition condition) {
        return Mono.empty();
    }


}
