package io.adelie.admin.service;

import io.adelie.admin.model.EProject;
import io.adelie.admin.repository.EProjectRepository;
import io.adelie.domain.project.ProjectNameRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class EProjectService {
    private final EProjectRepository eProjectRepository;

    public EProject createProject(ProjectNameRequest projectCreateRequest) {
        return eProjectRepository.save(EProject.builder()
                .projectName(projectCreateRequest.getProjectName())
                .build());
    }

    public boolean deleteProject(String projectName) {

        EProject byProjectName = eProjectRepository.findByProjectName(projectName);
        if (byProjectName == null) {
            return false;
        } else {
            eProjectRepository.deleteById(byProjectName.getProjectId());
            return true;
        }
    }

    public EProject getProject(String projectName) {
        return eProjectRepository.findByProjectName(projectName);
    }

    public Page<EProject> getAllProject(Pageable pageable) {
        return eProjectRepository.findAll(pageable);
    }
}
