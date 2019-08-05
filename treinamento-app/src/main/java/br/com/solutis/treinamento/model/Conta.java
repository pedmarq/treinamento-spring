package br.com.solutis.treinamento.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal valor;

    private char tipo;

    public Conta() {}

    public Conta(String descricao, BigDecimal valor, char tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
    }


}
