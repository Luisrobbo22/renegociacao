package br.com.robbo.renegociacao.DTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Calendar;

@Data
@Builder
public class DebitoDTO {

    private Integer id;

    private String descricaoDebito;

    private Calendar vencimento;

    private BigDecimal valor;

    private boolean isDebitoAberto;

}
