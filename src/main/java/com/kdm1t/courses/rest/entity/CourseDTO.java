package com.kdm1t.courses.rest.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CourseDTO {

    @NotEmpty
    private String name;
    @NotNull
    private Integer duration;
    @NotNull
    private Double price;
    @NotNull
    private String organization;
    @NotNull
    private String directionOfStudy;
    @NotNull
    private Boolean jobGuarantee;

    private Double priceInMonth;

}
