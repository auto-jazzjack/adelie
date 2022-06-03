package io.adelie.springql.core.resolver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExecutionPlan {
    private Resolver mySelf;
    private Map<String, ExecutionPlan> next;
    private Set<String> currFields;

    public void addNext(String key, ExecutionPlan value) {
        if (next == null) {
            next = new HashMap<>();
        }
        next.put(key, value);
    }
}
