package io.adelie.springql.core.resolver;

import java.util.List;

public interface ListResolver<Parent, Myself> extends Resolver<Myself> {

    default DataType getType() {
        return DataType.LIST;
    }

    void setData(Parent parent, List<Myself> myself);
}