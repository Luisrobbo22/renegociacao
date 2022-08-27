package br.com.robbo.renegociacao.service;

import br.com.robbo.renegociacao.entity.Pagamento;

import java.util.List;

public interface PagamentoService {

    Pagamento createPagamento(Pagamento pagamento, String email);

    List<Pagamento> findAll();
}
