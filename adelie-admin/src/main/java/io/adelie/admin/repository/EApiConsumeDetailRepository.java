package io.adelie.admin.repository;

import io.adelie.admin.model.EApiConsumeDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EApiConsumeDetailRepository extends CrudRepository<EApiConsumeDetail, Long> {

}
