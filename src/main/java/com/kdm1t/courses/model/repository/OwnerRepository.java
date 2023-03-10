package com.kdm1t.courses.model.repository;

import com.kdm1t.courses.model.entity.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Optional<Owner> findByOrganization(String organization);
}
