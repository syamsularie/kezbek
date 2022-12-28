package com.kezbek.application.service.impl;

import com.kezbek.application.entity.*;
import com.kezbek.application.helper.CountCashback;
import com.kezbek.application.helper.UpgradeTier;
import com.kezbek.application.repository.TransactionRepository;
import com.kezbek.application.repository.UserTierRepository;
import com.kezbek.application.request.TransactionRequest;
import com.kezbek.application.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private UserTierRepository userTierRepository;
    @Autowired
    private CountCashback countCashback;
    @Autowired
    private UpgradeTier upgradeTier;
    /**
     * this function is to count cashback and send it to customer e-wallet
     */
    @Override
    public Long add(TransactionRequest transactionRequest) {
        Transaction transaction = Transaction.builder()
                .email(transactionRequest.getEmail())
                .phone(transactionRequest.getPhone())
                .build();
        System.out.println(transactionRequest);
        Optional<UserTier> userTier = userTierRepository.findByEmail(transactionRequest.getEmail());

        transaction.setTransactionDetail(TransactionDetail.builder()
                .totalTransaction(transactionRequest.getTotalCheckout())
                .transaction(transaction)
                .totalAmount(transactionRequest.getAmount())
                .totalTransaction(transactionRequest.getTotalCheckout())
                .status(StatusTransaction.PROGRESS)
                .cashbackTypeA(countCashback.getCashbackTypeA(transactionRequest.getTotalCheckout(), transactionRequest.getAmount()))
                .cashbackTypeB(countCashback.getCashbackTypeB(userTier.isPresent()? userTier.get().getTierType() : null, userTier.isPresent() ? userTier.get().getTransactionCount()+1 : 0))
                .build()
        );
        transactionRepository.save(transaction);

        if (userTier.isPresent()) {
            UserTier updateUser = userTier.get();
            updateUser.setTransactionCount(userTier.get().getTransactionCount() == 7 ? 1 : userTier.get().getTransactionCount()+1);
            updateUser.setLastTransaction(LocalDateTime.now());
            updateUser.setTierType((userTier.get().getTransactionCount() == 7 ? upgradeTier.upgrade(userTier.get().getTierType()) : userTier.get().getTierType()));
            userTierRepository.save(updateUser);
        } else {
            UserTier newUser = UserTier.builder()
                    .email(transactionRequest.getEmail())
                    .transactionCount(1)
                    .lastTransaction(LocalDateTime.now())
                    .tierType(TierType.BRONZE)
                    .build();
            userTierRepository.save(newUser);
        }
        return 0L;
    }
}
