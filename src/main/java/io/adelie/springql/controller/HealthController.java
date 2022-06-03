package io.adelie.springql.controller;

import io.adelie.springql.core.resolver.ResolverService;
import io.adelie.springql.model.SampleRequest;
import io.adelie.springql.model.SampleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HealthController {

    private final ResolverService resolverService;

    @PostMapping(path = "/hello", produces = "application/json")
    public Mono<SampleResponse> hello(@RequestBody SampleRequest sampleRequest) {
        return resolverService.exec(sampleRequest);
    }
}
