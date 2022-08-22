package br.com.robbo.renegociacao.entity;

import br.com.robbo.renegociacao.entity.enums.TipoPagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_debito")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "dt_pagamento")
    private Calendar dataPagamento;

    @Column(name = "vl_pagamento")
    private BigDecimal valorPagamento;

    @Column(name = "tp_pagamento")
    @Enumerated(EnumType.STRING)
    private TipoPagamentoEnum tipoPagamentoEnum;

    @OneToOne
    private Debito debito;
}
