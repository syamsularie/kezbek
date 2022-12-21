package com.kezbek.application.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "channels")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Channel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean flag;
    private String category;

}
