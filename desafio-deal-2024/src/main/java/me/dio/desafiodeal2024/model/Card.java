package me.dio.desafiodeal2024.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity(name = "tb_card")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(name = "available_limit", scale = 13, precision = 2)
    private BigDecimal limit;

}
