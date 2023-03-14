package com.kdm1t.courses.rest.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class OwnerDTO {

    @NotEmpty
    private String organization;

}
