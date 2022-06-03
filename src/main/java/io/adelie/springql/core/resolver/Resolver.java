package io.adelie.springql.core.resolver;

import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Map;

public interface Resolver<Myself> {

    DataType getType();

    Mono<Myself> generate(Condition condition);

    default Map<String, Class<? extends Resolver>> next() {
        return Collections.emptyMap();
    }

    default void preHandler(Condition condition) {
        //do nothing
    }

    enum DataType {
        LIST,
        MAP,
        SINGLE
    }
}
