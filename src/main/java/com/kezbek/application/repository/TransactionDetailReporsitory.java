package com.kezbek.application.repository;

import com.kezbek.application.entity.TransactionDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDetailReporsitory extends JpaRepository<TransactionDetail, Long> {
}
