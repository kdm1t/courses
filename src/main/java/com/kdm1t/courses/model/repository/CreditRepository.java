package com.kdm1t.courses.model.repository;

import com.kdm1t.courses.model.entity.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
}
