package io.adelie.springql.core.resolver;

import io.adelie.springql.model.SampleRequest;
import io.adelie.springql.model.SampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ResolverService {

    private final ExecutionPlanGenerator executionPlanGenerator;
    private final ExecutionPlanExecutor executionPlanExecutor;

    public Mono<SampleResponse> exec(SampleRequest sampleRequest) {
        ExecutionPlan generate = executionPlanGenerator.generate(GqlParser.parseFrom(sampleRequest.getGqlQuery()));
        return executionPlanExecutor.exec(generate);
    }
}
