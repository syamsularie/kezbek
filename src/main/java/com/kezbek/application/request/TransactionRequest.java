package com.kezbek.application.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TransactionRequest {
    private String email;
    private String phone;
    private int totalTransaction;
    private Double amount;
}
