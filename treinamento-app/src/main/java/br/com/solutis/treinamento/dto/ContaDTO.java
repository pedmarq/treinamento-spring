package br.com.solutis.treinamento.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ContaDTO {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private Character tipo;
}
