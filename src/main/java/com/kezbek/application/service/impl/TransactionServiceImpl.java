package com.kezbek.application.service.impl;

import com.kezbek.application.entity.*;
import com.kezbek.application.repository.TransactionRepository;
import com.kezbek.application.repository.UserTierRepository;
import com.kezbek.application.request.TransactionRequest;
import com.kezbek.application.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserTierRepository userTierRepository;

    @Override
    public Long add(TransactionRequest transactionRequest) {
        Transaction transaction = Transaction.builder()
                .email(transactionRequest.getEmail())
                .phone(transactionRequest.getPhone())
                .build();
        transaction.setTransactionDetail(TransactionDetail.builder()
                .totalTransaction(transactionRequest.getTotalTransaction())
                .transaction(transaction)
                .totalAmount(transactionRequest.getAmount())
                .totalTransaction(transactionRequest.getTotalTransaction())
                .status(StatusTransaction.PROGRESS)
                .build()
        );
        Optional<UserTier> userTier = userTierRepository.findByEmail(transactionRequest.getEmail());

        if (userTier.isPresent()) {
            System.out.println("email:"+userTier.get().getEmail());
            userTierRepository.updateUserTier(userTier.get().getEmail(), userTier.get().getTierType(), userTier.get().getTransactionCount()+1, LocalDateTime.now());
        } else {
            UserTier newUser = UserTier.builder()
                    .email(transactionRequest.getEmail())
                    .transactionCount(1)
                    .lastTransaction(LocalDateTime.now())
                    .tierType(TierType.BRONZE)
                    .build();
            userTierRepository.save(newUser);
        }
        return transactionRepository.save(transaction).getId();
    }
}
