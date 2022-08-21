package io.adelie.domain.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSearchResponse {
    private Long projectId;
    private String projectName;
    private String createAt;
    private String updatedAt;
}
