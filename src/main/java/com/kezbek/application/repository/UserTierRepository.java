package com.kezbek.application.repository;

import com.kezbek.application.entity.TierType;
import com.kezbek.application.entity.UserTier;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface UserTierRepository extends JpaRepository<UserTier, Long> {
    @Query(
            value = "SELECT * FROM user_tiers ut WHERE email = :email",
            nativeQuery = true
    )
    Optional<UserTier> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE user_tiers SET tier_type = :tierType, transaction_count = :transactionCount, last_transaction = :lastTransaction WHERE email = :email",
            nativeQuery = true
    )
    void updateUserTier(String email, TierType tierType, int transactionCount, LocalDateTime lastTransaction);
}
