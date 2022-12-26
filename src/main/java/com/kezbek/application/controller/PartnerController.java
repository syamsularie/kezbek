package com.kezbek.application.controller;

import com.kezbek.application.entity.Partner;
import com.kezbek.application.repository.PartnerRepository;
import com.kezbek.application.service.PartnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/partner")
public class PartnerController {
    @Autowired
    PartnerService partnerService;

    @PostMapping(value = "/v1/addPartner")
    public ResponseEntity<?> addPartner(@RequestBody @Valid Partner partner){
        Long partnerId = partnerService.add(partner);
        Map<String, Object> response = new TreeMap<>();
        response.put("status_code", "00");
        response.put("status_desc", "Parner added successfully. ID " + partnerId );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
