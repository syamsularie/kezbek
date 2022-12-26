package com.kezbek.application.controller;

import com.kezbek.application.entity.Partner;
import com.kezbek.application.request.TransactionRequest;
import com.kezbek.application.service.TransactionService;
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
@RequestMapping(value = "/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping(value = "/v1/addTransaction")
    public ResponseEntity<?> addPartner(@RequestBody @Valid TransactionRequest transactionRequest){
        Long transactionId = transactionService.add(transactionRequest);
        Map<String, Object> response = new TreeMap<>();
        response.put("status_code", "00");
        response.put("status_desc", "Transaction added successfully. ID " + transactionId);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
