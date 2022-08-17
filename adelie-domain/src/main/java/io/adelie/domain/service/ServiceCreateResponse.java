package io.adelie.domain.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class ServiceCreateResponse {
    private Long serviceId;
    private String serviceName;
}
