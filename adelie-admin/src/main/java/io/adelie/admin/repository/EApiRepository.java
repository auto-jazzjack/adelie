package io.adelie.admin.repository;

import io.adelie.admin.model.EApi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EApiRepository extends CrudRepository<EApi, Long> {

}
