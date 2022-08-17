package io.adelie.admin.controller;

import io.adelie.admin.model.EService;
import io.adelie.admin.service.EServiceService;
import io.adelie.domain.service.ServiceCreateRequest;
import io.adelie.domain.service.ServiceCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/service")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ServiceController {

    private final EServiceService eServiceService;


    @PostMapping(value = "", consumes = "application/json")
    public ServiceCreateResponse createService(@RequestBody ServiceCreateRequest serviceCreateRequest) {
        return to(eServiceService.createService(serviceCreateRequest));
    }

    private static ServiceCreateResponse to(EService eServiceService) {
        return ServiceCreateResponse.builder()
                .serviceId(eServiceService.getServiceId())
                .serviceName(eServiceService.getServiceName())
                .build();
    }
}
