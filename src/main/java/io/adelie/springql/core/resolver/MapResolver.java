package io.adelie.springql.core.resolver;

import io.adelie.springql.model.Pair;

import java.util.Map;

public interface MapResolver<Parent, Myself, Key> extends Resolver<Pair<Key, Myself>> {

    default DataType getType() {
        return DataType.MAP;
    }

    void setData(Parent parent, Map<Key, Myself> myselfMap);


}
