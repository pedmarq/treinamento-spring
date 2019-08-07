package br.com.solutis.treinamento.model.entity;

import br.com.solutis.treinamento.model.enums.ContaCicloEnum;
import br.com.solutis.treinamento.model.enums.ContaTipoEnum;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private ContaTipoEnum tipo;

    @Column(nullable = false)
    private ContaCicloEnum ciclo;

    @Column(nullable = false)
    private Integer parcelas;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date dataCriacao;

    public Conta() {}

    public Conta(String nome, ContaTipoEnum tipo, ContaCicloEnum ciclo, Integer parcelas, BigDecimal valor, Date dataCriacao) {
        this.nome = nome;
        this.tipo = tipo;
        this.ciclo = ciclo;
        this.parcelas = parcelas;
        this.valor = valor;
        this.dataCriacao = dataCriacao;
    }


}
