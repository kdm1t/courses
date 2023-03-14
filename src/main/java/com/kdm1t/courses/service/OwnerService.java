package com.kdm1t.courses.service;

import com.kdm1t.courses.model.entity.Owner;
import com.kdm1t.courses.model.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public Owner findOrCreate(String organization) {
        return ownerRepository.findByOrganizationIgnoreCase(organization).orElseGet(() -> create(organization));
    }

    private Owner create(String organization) {
        Owner owner = new Owner();
        owner.setOrganization(organization);
        return ownerRepository.save(owner);
    }

}
