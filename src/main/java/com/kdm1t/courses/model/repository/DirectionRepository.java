package com.kdm1t.courses.model.repository;

import com.kdm1t.courses.model.entity.Direction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectionRepository extends CrudRepository<Direction, Long> {
    Optional<Direction> findByDirectionOfStudy(String directionOfStudy);
}
