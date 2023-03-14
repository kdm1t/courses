package com.kdm1t.courses.rest.controller;

import com.google.common.collect.Lists;
import com.kdm1t.courses.model.entity.Course;
import com.kdm1t.courses.model.repository.CourseRepository;
import com.kdm1t.courses.rest.RestExceptionHandlers;
import com.kdm1t.courses.rest.entity.CourseDTO;
import com.kdm1t.courses.rest.entity.CourseDTOList;
import com.kdm1t.courses.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
@Slf4j
public class CourseController extends RestExceptionHandlers {

    private final CourseRepository courseRepository;
    private final CourseService courseService;

    @GetMapping(value = "/get_all", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Course> getAll() {
        return Lists.newArrayList(courseRepository.findAll());
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    private Course add(@RequestBody @Valid CourseDTO request) {
        return courseService.create(request);
    }

    @PostMapping(value = "/add_all", produces = MediaType.APPLICATION_JSON_VALUE)
    private List<Course> addAll(@RequestBody @Valid CourseDTOList request) {
        return request.getCourses().stream()
                .map(courseService::create)
                .toList();
    }

}
