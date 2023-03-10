package com.kdm1t.courses.rest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class CourseDTO {

    private String name;
    private Integer duration;
    private Double price;
    private String organization;
    private boolean jobGuarantee;
    private String directionOfStudy;
    private Double priceInMonth;

}
