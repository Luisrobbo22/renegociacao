package br.com.robbo.renegociacao.entity;

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
public class Debito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "ds_debito")
    private String descricaoDebito;

    @Column(name = "dt_vencimento")
    private Calendar vencimento;

    private BigDecimal valor;

    private boolean isDebitoAberto;

    @ManyToOne
    private Cliente cliente;

    @OneToOne
    private Pagamento pagamento;

}
