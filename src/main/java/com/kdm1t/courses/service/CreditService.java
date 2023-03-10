package com.kdm1t.courses.service;

import com.kdm1t.courses.model.entity.Credit;
import com.kdm1t.courses.model.repository.CreditRepository;
import lombok.RequiredArgsConstructor;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreditService {

    private final CreditRepository creditRepository;

    public Credit create(Double priceInMonth) {
        Credit credit = new Credit();
        credit.setPriceInMonth(priceInMonth);
        credit.setAvailable(priceInMonth != null);
        return creditRepository.save(credit);
    }

}
