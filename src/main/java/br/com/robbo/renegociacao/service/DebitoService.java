package br.com.robbo.renegociacao.service;

import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.Debito;
import br.com.robbo.renegociacao.entity.Pagamento;

import java.util.List;

public interface DebitoService {

    List<Debito> getDebitoByEmailCliente(String email);

    List<Debito> getDebitosByClienteEmailAndDebitosAberto(String email, String isDebitoAberto);

    List<DebitoDTO> updateStatusDebito(List<Debito> debito);

    List<Debito> createDebito(List<Debito> debitos);

    void updatePagamentoDebito(Pagamento pagamentoRealizado, List<DebitoDTO> dtos);


}
