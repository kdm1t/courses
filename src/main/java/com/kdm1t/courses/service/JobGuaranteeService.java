package com.kdm1t.courses.service;

import com.kdm1t.courses.model.entity.JobGuarantee;
import com.kdm1t.courses.model.repository.JobGuaranteeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JobGuaranteeService {

    private final JobGuaranteeRepository jobGuaranteeRepository;

    public JobGuarantee create(boolean jobGuarantee) {
        JobGuarantee jb = new JobGuarantee();
        jb.setJobGuarantee(jobGuarantee);
        return jobGuaranteeRepository.save(jb);
    }

}
