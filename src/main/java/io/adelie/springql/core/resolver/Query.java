package io.adelie.springql.core.resolver;

import lombok.Builder;
import lombok.Data;

import java.util.Map;
import java.util.Set;

@Data
@Builder
public class Query {
    private Map<String, Query> queryByResolverName;
    private Set<String> fields;
}
