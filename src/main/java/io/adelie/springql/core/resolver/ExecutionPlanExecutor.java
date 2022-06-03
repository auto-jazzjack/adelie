package io.adelie.springql.core.resolver;

import io.adelie.springql.model.SampleResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ExecutionPlanExecutor {

    public Mono<SampleResponse> exec(ExecutionPlan executionPlan) {
        return Mono.empty();
    }
}
