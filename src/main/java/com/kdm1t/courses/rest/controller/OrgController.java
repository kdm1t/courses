package com.kdm1t.courses.rest.controller;

import com.google.common.collect.Lists;
import com.kdm1t.courses.model.entity.Owner;
import com.kdm1t.courses.model.repository.OwnerRepository;
import com.kdm1t.courses.rest.RestExceptionHandlers;
import com.kdm1t.courses.rest.entity.OwnerDTO;
import com.kdm1t.courses.rest.entity.OwnerDTOList;
import com.kdm1t.courses.service.OwnerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/organizations")
public class OrgController extends RestExceptionHandlers {

    private final OwnerRepository ownerRepository;
    private final OwnerService ownerService;

    @GetMapping(value = "/get_all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    List<Owner> getAll() {
        return Lists.newArrayList(ownerRepository.findAll());
    }

    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    Owner add(@RequestBody @Valid OwnerDTO ownerDTO) {
        return ownerService.findOrCreate(ownerDTO.getOrganization());
    }

    @PostMapping(value = "/add_all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    List<Owner> addAll(@RequestBody @Valid OwnerDTOList ownerDTOs) {
        return ownerDTOs.getOwners().stream()
                .map(OwnerDTO::getOrganization)
                .map(ownerService::findOrCreate)
                .toList();
    }

    @PostMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    @Transactional
    void delete(@RequestBody @Valid OwnerDTO ownerDTO) {
        ownerRepository.deleteByOrganization(ownerDTO.getOrganization());
    }

}
