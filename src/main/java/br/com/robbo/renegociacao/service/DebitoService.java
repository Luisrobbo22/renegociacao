package br.com.robbo.renegociacao.service;

import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.Debito;

import java.util.List;

public interface DebitoService {

    List<Debito> getDebitoByEmailCliente(String email);

    List<DebitoDTO> updateStatusDebito(List<Debito> debito);

    List<Debito> createDebito(List<Debito> debitos);
}
