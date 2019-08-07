package br.com.solutis.treinamento.model.dto;

import br.com.solutis.treinamento.model.enums.ContaCicloEnum;
import br.com.solutis.treinamento.model.enums.ContaTipoEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ContaDTO {
    private Long id;
    private String nome;
    private ContaTipoEnum tipo;
    private ContaCicloEnum ciclo;
    private Integer parcelas;
    private BigDecimal valor;
    private LocalDate dataCriacao;
    private Long idPrimeiraParcela;
}
