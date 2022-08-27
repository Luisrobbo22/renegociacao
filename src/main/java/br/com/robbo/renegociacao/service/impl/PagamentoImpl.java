package br.com.robbo.renegociacao.service.impl;

import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.Debito;
import br.com.robbo.renegociacao.entity.Pagamento;
import br.com.robbo.renegociacao.repository.PagamentoRepository;
import br.com.robbo.renegociacao.service.DebitoService;
import br.com.robbo.renegociacao.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private DebitoService debitoService;

    @Override
    public Pagamento createPagamento(Pagamento pagamento, String email) {
        List<Debito> debitos = debitoService.getDebitoByEmailCliente(email);
        List<DebitoDTO> debitoList = debitoService.updateStatusDebito(debitos);
        pagamento.setDebitoDTO(debitoList);
        return pagamentoRepository.save(pagamento);
    }

    @Override
    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }

}
