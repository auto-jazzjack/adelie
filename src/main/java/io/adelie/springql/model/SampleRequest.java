package io.adelie.springql.model;

import io.adelie.springql.core.resolver.Query;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SampleRequest {
    private Query query;
    private List<Long> ids;
}
