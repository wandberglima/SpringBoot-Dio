package me.dio.desafiodeal2024.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Entity(name = "tb_account")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String number;

    @Column(nullable = false, unique = true)
    private String agency;

    @Column(scale = 2, precision = 13)
    private BigDecimal balance;

    @Column(name = "additional_limit", scale = 2, precision = 13)
    private BigDecimal limit;

}
