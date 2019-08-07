package br.com.solutis.treinamento.model.dto;

import br.com.solutis.treinamento.model.enums.ContaCicloEnum;
import br.com.solutis.treinamento.model.enums.ContaTipoEnum;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class ContaDTO {
    private Long id;
    private String nome;
    private ContaTipoEnum tipo;
    private ContaCicloEnum ciclo;
    private Integer parcelas;
    private BigDecimal valor;
    private Date dataCriacao;
}
