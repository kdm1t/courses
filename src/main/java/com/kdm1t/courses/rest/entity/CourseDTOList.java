package com.kdm1t.courses.rest.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class CourseDTOList {

    @NotEmpty
    private List<@Valid CourseDTO> courses;

}
