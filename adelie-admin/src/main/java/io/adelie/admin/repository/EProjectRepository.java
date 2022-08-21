package io.adelie.admin.repository;

import io.adelie.admin.model.EProject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EProjectRepository extends CrudRepository<EProject, Long> {

    EProject findByProjectName(String projectName);
}
