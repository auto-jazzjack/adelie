package io.adelie.springql.core.resolver;

import io.adelie.springql.model.SampleResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RootResolver implements Resolver<SampleResponse> {

    @Override
    public DataType getType() {
        return DataType.OBJECT;
    }

    @Override
    public Mono<SampleResponse> generate(Condition condition) {
        return Mono.empty();
    }
}
