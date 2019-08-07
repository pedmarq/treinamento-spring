package br.com.solutis.treinamento.model.entity;

import br.com.solutis.treinamento.model.enums.ContaCicloEnum;
import br.com.solutis.treinamento.model.enums.ContaTipoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private LocalDate dataCriacao;

    @Column(nullable = true)
    private Long idPrimeiraParcela;
}
