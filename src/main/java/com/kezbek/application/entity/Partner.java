package com.kezbek.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name = "partners")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Partner extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    private String name;
    private String description;
    private String category;
    @OneToMany(mappedBy = "partner", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Transaction> transactions;
}
