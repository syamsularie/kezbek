package com.kezbek.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.DatagramPacket;

@Entity
@Data
@Table(name = "transaction_details")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionDetail extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;
    private Double totalAmount;
    private int totalTransaction;
    private Double cashbackTypeA;
    private Double cashbackTypeB;
    private Double totalCashback;
    private StatusTransaction status = StatusTransaction.PROGRESS;
}
