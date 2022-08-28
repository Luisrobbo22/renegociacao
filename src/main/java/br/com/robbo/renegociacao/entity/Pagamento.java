package br.com.robbo.renegociacao.entity;

import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dt_pagamento")
    private Calendar dataPagamento;

    @Column(name = "vl_pagamento")
    private BigDecimal valorPagamento;

    @Column(name = "tp_pagamento")
    @Enumerated(EnumType.STRING)
    private TipoPagamentoEnum tipoPagamentoEnum;


    @Transient
    private List<DebitoDTO> debitoDTO;
}
