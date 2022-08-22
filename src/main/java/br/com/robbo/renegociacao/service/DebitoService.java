package br.com.robbo.renegociacao.service;

import br.com.robbo.renegociacao.entity.Cliente;
import br.com.robbo.renegociacao.entity.Debito;

import java.util.List;

public interface DebitoService {

    List<Debito> getDebitoByEmailCliente(Cliente cliente);

    Debito updateStatusDebito(Debito debito);
}
