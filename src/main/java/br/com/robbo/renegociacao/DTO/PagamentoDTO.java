package br.com.robbo.renegociacao.DTO;

import br.com.robbo.renegociacao.entity.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Calendar;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PagamentoDTO {

    private Calendar dataPagamento;

    private BigDecimal valorPagamento;

    private TipoPagamentoEnum tipoPagamentoEnum;

}
