package br.com.robbo.renegociacao.service.impl;

import br.com.robbo.renegociacao.entity.Cliente;
import br.com.robbo.renegociacao.entity.Debito;
import br.com.robbo.renegociacao.repository.DebitoRepository;
import br.com.robbo.renegociacao.service.DebitoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DebitoServiceImpl implements DebitoService {

    @Autowired
    private DebitoRepository debitoRepository;


    @Override
    public List<Debito> getDebitoByEmailCliente(Cliente cliente) {
        return debitoRepository.findDebitosByClienteEmail(cliente.getEmail());
    }

    @Override
    public Debito updateStatusDebito(Debito debito) {
        return null;
    }

}
