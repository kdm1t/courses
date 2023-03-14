package com.kdm1t.courses.rest.entity;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OwnerDTOList {

    @NotEmpty
    private List<@Valid OwnerDTO> owners;

}
