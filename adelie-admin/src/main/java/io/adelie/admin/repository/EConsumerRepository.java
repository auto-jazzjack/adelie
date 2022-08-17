package io.adelie.admin.repository;

import io.adelie.admin.model.EConsumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EConsumerRepository extends CrudRepository<EConsumer, Long> {

}
