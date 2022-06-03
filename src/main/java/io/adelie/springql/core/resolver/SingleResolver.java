package io.adelie.springql.core.resolver;

import reactor.core.publisher.Mono;

import static io.adelie.springql.core.resolver.Resolver.DataType.SINGLE;

public interface SingleResolver<Parent, Myself> extends Resolver<Myself> {

    default DataType getType() {
        return SINGLE;
    }

    Mono<Myself> generate(Condition condition);

    void setData(Parent parent, Myself myself);
}
