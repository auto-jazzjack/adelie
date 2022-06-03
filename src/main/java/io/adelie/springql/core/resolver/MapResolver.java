package io.adelie.springql.core.resolver;

public interface MapResolver<Parent, Myself> extends Resolver<Myself> {

    default DataType getType() {
        return DataType.MAP;
    }

}
