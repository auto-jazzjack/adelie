package io.adelie.admin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/service")
public class ServiceController {

    @PostMapping(value = "", consumes = "application/json")
    public void createService() {

    }
}
