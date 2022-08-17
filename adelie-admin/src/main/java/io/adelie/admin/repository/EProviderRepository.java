package io.adelie.admin.repository;

import io.adelie.admin.model.EProvider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EProviderRepository extends CrudRepository<EProvider, Long> {

}
