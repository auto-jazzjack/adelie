package io.adelie.admin.repository;

import io.adelie.admin.model.EProject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EProjectRepository extends CrudRepository<EProject, Long> {

    EProject findByProjectName(String projectName);

    Page<EProject> findAll(Pageable pageable);
}
