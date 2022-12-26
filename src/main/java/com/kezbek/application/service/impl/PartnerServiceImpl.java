package com.kezbek.application.service.impl;

import com.kezbek.application.entity.Partner;
import com.kezbek.application.repository.PartnerRepository;
import com.kezbek.application.service.PartnerService;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    @Override
    public Long add(Partner partnerInput) {
        Partner partner = Partner.builder()
                .name(partnerInput.getName())
                .description(partnerInput.getDescription())
                .category(partnerInput.getCategory())
                .build();
        return partnerRepository.save(partner).getId();
    }
}
