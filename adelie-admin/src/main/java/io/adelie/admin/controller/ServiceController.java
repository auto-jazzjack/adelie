package io.adelie.admin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import io.adelie.domain.service.*;

@RestController("/api/service")
public class ServiceController {

    @PostMapping(value = "", consumes = "application/json")
    public ServiceCreateResponse createService(@RequestBody ServiceCreateRequest serviceCreateRequest) {
        return null;
    }
}
