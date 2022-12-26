package com.kezbek.application.service;

import com.kezbek.application.entity.Transaction;
import com.kezbek.application.request.TransactionRequest;

public interface TransactionService {
    Long add(TransactionRequest transactionRequest);
}
