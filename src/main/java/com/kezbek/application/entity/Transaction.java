package com.kezbek.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "transactions")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 15)
    private String phone;
    @NotNull
    @NotEmpty
    private String email;
    @ManyToOne
    @JoinColumn(name = "partner_id")
    private Partner partner;

    @OneToOne(mappedBy = "transaction", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private TransactionDetail transactionDetail;
}
