package com.kdm1t.courses.service;

import com.kdm1t.courses.model.entity.Direction;
import com.kdm1t.courses.model.repository.DirectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DirectionService {

    private final DirectionRepository directionRepository;

    public Direction create(String directionOfStudy) {
        Direction direction = new Direction();
        direction.setDirectionOfStudy(directionOfStudy);
        return directionRepository.save(direction);
    }

}
