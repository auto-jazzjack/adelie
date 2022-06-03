package io.adelie.springql.controller;

import io.adelie.springql.model.SampleRequest;
import io.adelie.springql.model.SampleResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController("/")
public class HealthController {

    @PostMapping(path = "/hello", produces = "application/json")
    public Mono<SampleResponse> hello(@RequestBody SampleRequest sampleRequest) {
        return Mono.empty();
    }
}
