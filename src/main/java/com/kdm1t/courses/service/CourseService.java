package com.kdm1t.courses.service;

import com.kdm1t.courses.model.entity.*;
import com.kdm1t.courses.model.repository.CourseRepository;
import com.kdm1t.courses.rest.entity.CourseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final OwnerService ownerService;
    private final JobGuaranteeService jobGuaranteeService;
    private final DirectionService directionService;
    private final CreditService creditService;

    public Course create(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDuration(courseDTO.getDuration());
        course.setPrice(courseDTO.getPrice());
        course.setOwner(ownerService.findOrCreate(courseDTO.getOrganization()));
        course.setCredit(creditService.create(courseDTO.getPriceInMonth()));
        course.setJobGuarantee(jobGuaranteeService.findOrCreate(courseDTO.getJobGuarantee()));
        course.setDirectionOfStudy(directionService.findOrCreate(courseDTO.getDirectionOfStudy()));
        return courseRepository.save(course);
    }

    //TODO: Убрать в Builder
    public Course generate(CourseDTO courseDTO) {
        Course course = new Course();
        course.setName(courseDTO.getName());
        course.setDuration(courseDTO.getDuration());
        course.setPrice(courseDTO.getPrice());
        Owner owner = new Owner();
        owner.setOrganization(courseDTO.getOrganization());
        course.setOwner(owner);
        JobGuarantee jobGuarantee = new JobGuarantee();
        jobGuarantee.setJobGuarantee(courseDTO.getJobGuarantee());
        course.setJobGuarantee(jobGuarantee);
        Direction direction = new Direction();
        direction.setDirectionOfStudy(courseDTO.getDirectionOfStudy());
        course.setDirectionOfStudy(direction);
        Credit credit = new Credit();
        credit.setPriceInMonth(courseDTO.getPriceInMonth());
        if (courseDTO.getPriceInMonth() != null) {
            credit.setAvailable(true);
        }
        course.setCredit(credit);
        return course;
    }

}
