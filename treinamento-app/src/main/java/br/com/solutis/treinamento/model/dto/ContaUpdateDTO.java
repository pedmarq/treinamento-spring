package br.com.solutis.treinamento.model.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@Getter
@Setter
public class ContaUpdateDTO {
    private String nome;
    private BigDecimal valor;
    private LocalDate dataCriacao;
}
