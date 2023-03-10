package com.kdm1t.courses.rest.controller;

import com.google.common.collect.Lists;
import com.kdm1t.courses.model.entity.Course;
import com.kdm1t.courses.model.repository.CourseRepository;
import com.kdm1t.courses.rest.entity.CourseDTO;
import com.kdm1t.courses.service.CourseService;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @GetMapping(value = "/get_all", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Course> getAll() {
        return Lists.newArrayList(courseRepository.findAll());
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private Course add(@RequestBody CourseDTO request) {
        if (!checkRequest(request)) {
            return new Course();
        }
        return courseService.create(request);
    }

    @PostMapping(value = "/add_all", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Course> addAll(@RequestBody List<CourseDTO> request) {
        return request.stream()
                .filter(this::checkRequest)
                .map(courseService::create)
                .collect(Collectors.toList());
    }

    private boolean checkRequest(CourseDTO request) {
        return StringUtils.isNotEmpty(request.getName())
                && request.getDuration() != null
                && request.getPrice() != null
                && StringUtils.isNotEmpty(request.getOrganization())
                && StringUtils.isNotEmpty(request.getDirectionOfStudy());
    }

}
