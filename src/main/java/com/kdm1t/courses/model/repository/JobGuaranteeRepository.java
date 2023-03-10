package com.kdm1t.courses.model.repository;

import com.kdm1t.courses.model.entity.JobGuarantee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobGuaranteeRepository extends CrudRepository<JobGuarantee, Long> {

    Optional<JobGuarantee> findByJobGuarantee(Boolean jobGuarantee);

}
