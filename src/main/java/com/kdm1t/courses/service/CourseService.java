package com.kdm1t.courses.service;

import com.kdm1t.courses.model.entity.*;
import com.kdm1t.courses.model.repository.CourseRepository;
import com.kdm1t.courses.model.repository.DirectionRepository;
import com.kdm1t.courses.model.repository.JobGuaranteeRepository;
import com.kdm1t.courses.model.repository.OwnerRepository;
import com.kdm1t.courses.rest.entity.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final OwnerRepository ownerRepository;
    private final JobGuaranteeRepository jobGuaranteeRepository;
    private final DirectionRepository directionRepository;
    private final OwnerService ownerService;
    private final JobGuaranteeService jobGuaranteeService;
    private final DirectionService directionService;
    private final CreditService creditService;

    public Course create(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDuration(courseDTO.getDuration());
        course.setPrice(courseDTO.getPrice());

        Owner owner = ownerRepository.findByOrganization(courseDTO.getOrganization())
                .orElseGet(() -> ownerService.create(courseDTO.getOrganization()));
        course.setOwner(owner);

        Credit credit = creditService.create(courseDTO.getPriceInMonth());
        course.setCredit(credit);

        JobGuarantee jobGuarantee = jobGuaranteeRepository.findByJobGuarantee(courseDTO.isJobGuarantee())
                .orElseGet(() -> jobGuaranteeService.create(courseDTO.isJobGuarantee()));
        course.setJobGuarantee(jobGuarantee);

        Direction direction = directionRepository.findByDirectionOfStudy(courseDTO.getDirectionOfStudy())
                .orElseGet(() -> directionService.create(courseDTO.getDirectionOfStudy()));
        course.setDirectionOfStudy(direction);

        return courseRepository.save(course);
    }
    
}
