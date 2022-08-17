package io.adelie.admin.repository;

import io.adelie.admin.model.EService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EServiceRepository extends CrudRepository<EService, Long> {

}
