package com.kezbek.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_tiers")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTier extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String email;
    private TierType tierType = TierType.BRONZE;
    private int transactionCount;
    private LocalDateTime lastTransaction;
}
