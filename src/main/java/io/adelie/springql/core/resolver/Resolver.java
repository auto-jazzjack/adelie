package io.adelie.springql.core.resolver;

import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
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

    static <P, M> void setData(Resolver<M> resolver, P parent, M data) {
        if (resolver instanceof MapResolver) {
            ((MapResolver<P, Object, Object>) resolver).setData(parent, (Map<Object, Object>) data);
        } else if (resolver instanceof ListResolver) {
            ((ListResolver<P, Object>) resolver).setData(parent, (List<Object>) data);
        } else {
            ((SingleResolver<P, M>) resolver).setData(parent, data);
        }
    }
}
