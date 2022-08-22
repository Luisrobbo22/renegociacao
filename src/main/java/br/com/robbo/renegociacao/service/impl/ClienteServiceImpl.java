package br.com.robbo.renegociacao.service.impl;

import br.com.robbo.renegociacao.entity.Cliente;
import br.com.robbo.renegociacao.repository.ClienteRepository;
import br.com.robbo.renegociacao.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente getClienteByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    @Override
    public Cliente createCliente(Cliente cliente) {
        final Cliente result = getClienteByEmail(cliente.getEmail());
        if (result == null) {
            return clienteRepository.save(cliente);
        }
        return null;
    }

    @Override
    public Cliente updateCliente(String email, Cliente newCliente) {
        final Cliente cliente = getClienteByEmail(email);
        cliente.setNome(newCliente.getNome());
        cliente.setCelular(newCliente.getCelular());
        cliente.setTelefone(newCliente.getTelefone());

        return clienteRepository.saveAndFlush(cliente);
    }
}
