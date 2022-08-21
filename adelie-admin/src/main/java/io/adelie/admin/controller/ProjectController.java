package io.adelie.admin.controller;

import io.adelie.admin.model.EProject;
import io.adelie.admin.service.EProjectService;
import io.adelie.domain.project.ProjectCreateRequest;
import io.adelie.domain.project.ProjectCreateResponse;
import io.adelie.domain.project.ProjectSearchResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(value = "/api/project")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjectController {

    private final EProjectService eProjectService;

    @PostMapping(path = "", consumes = "application/json", produces = "application/json")
    public ProjectCreateResponse createProject(@RequestBody ProjectCreateRequest serviceCreateRequest) {
        return to(eProjectService.createProject(serviceCreateRequest));
    }

    @GetMapping(path = "", produces = "application/json")
    public ProjectCreateResponse getProject(@RequestParam(name = "projectName") String projectName) {
        return Optional.ofNullable(eProjectService.getProject(projectName))
                .map(i -> ProjectCreateResponse.builder()
                        .projectId(i.getProjectId())
                        .projectName(i.getProjectName())
                        .createAt(i.getCreatedAt().toString())
                        .updatedAt(i.getUpdatedAt().toString())
                        .build())
                .orElse(null);

    }

    @GetMapping(path = "/all", produces = "application/json")
    public Page<ProjectSearchResponse> getAllProject(
            @PageableDefault(size = 15, sort = "projectName") Pageable pageable
    ) {

        return eProjectService.getAllProject(pageable)
                .map(j -> ProjectSearchResponse.builder()
                        .projectId(j.getProjectId())
                        .projectName(j.getProjectName())
                        .createAt(j.getCreatedAt().toString())
                        .updatedAt(j.getUpdatedAt().toString())
                        .build());

    }

    private static ProjectCreateResponse to(EProject eProjectService) {
        return ProjectCreateResponse.builder()
                .projectId(eProjectService.getProjectId())
                .projectName(eProjectService.getProjectName())
                .build();
    }
}
