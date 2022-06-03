package io.adelie.springql.core.resolver;

import reactor.core.publisher.Mono;

public interface Resolver<V> {

    DataType getType();

    Mono<V> generate(Condition condition);

    default void preHandler(Condition condition) {
        //do nothing
    }

    enum DataType {
        LIST,
        MAP,
        OBJECT,
        SCALAR
    }
}
