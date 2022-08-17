package io.adelie.domain.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceCreateResponse {
    private Long serviceId;
    private String serviceName;
    private String createAt;
    private String updatedAt;
}
