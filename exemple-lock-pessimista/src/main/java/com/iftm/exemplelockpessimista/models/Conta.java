package com.iftm.exemplelockpessimista.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.lang.annotation.Documented;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name")
    private String fullName;
    private String conta;
    private String agencia;
    private Double saldo;
    @Version
    private int version;


    public Double sacar( Double valor) {
        return this.saldo -= valor;
    }

    public Double depositar( Double valor ) {
        return this.saldo += valor;
    }
}
