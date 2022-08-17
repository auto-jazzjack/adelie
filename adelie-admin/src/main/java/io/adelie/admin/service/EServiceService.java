package io.adelie.admin.service;

import io.adelie.admin.model.EService;
import io.adelie.admin.repository.EServiceRepository;
import io.adelie.domain.service.ServiceCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EServiceService {
    private final EServiceRepository eServiceRepository;

    public EService createService(ServiceCreateRequest serviceCreateRequest) {
        return eServiceRepository.save(EService.builder().build());
    }
}
