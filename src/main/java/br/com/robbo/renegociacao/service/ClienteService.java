package br.com.robbo.renegociacao.service;

import br.com.robbo.renegociacao.entity.Cliente;

public interface ClienteService {

    Cliente getClienteByEmail(String email);

    Cliente createCliente(Cliente cliente);

    Cliente updateCliente(String email, Cliente newCliente);
}
