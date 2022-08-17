package io.adelie.admin.controller;

import io.adelie.admin.model.EService;
import io.adelie.admin.service.EServiceService;
import io.adelie.domain.service.ServiceCreateRequest;
import io.adelie.domain.service.ServiceCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController(value = "/api/service")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceController {

    private final EServiceService eServiceService;

    @PostMapping(path = "/d", consumes = "application/json", produces = "application/json")
    public ServiceCreateResponse createService(@RequestBody ServiceCreateRequest serviceCreateRequest) {
        return to(eServiceService.createService(serviceCreateRequest));
    }

    /*@GetMapping(value = "/qsd", produces = "application/json")
    public ServiceCreateResponse getService(@RequestParam(name = "serviceName") String serviceName) {
        return to(eServiceService.getService(serviceName));
    }*/

    private static ServiceCreateResponse to(EService eServiceService) {
        return ServiceCreateResponse.builder()
                .serviceId(eServiceService.getServiceId())
                .serviceName(eServiceService.getServiceName())
                .build();
    }
}
