package br.com.robbo.renegociacao.service.impl;

import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.Debito;
import br.com.robbo.renegociacao.entity.Pagamento;
import br.com.robbo.renegociacao.repository.PagamentoRepository;
import br.com.robbo.renegociacao.service.DebitoService;
import br.com.robbo.renegociacao.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagamentoImpl implements PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private DebitoService debitoService;

    @Override
    public Pagamento createPagamento(Pagamento pagamento, String email) {
        List<Debito> debitos = debitoService.getDebitosByClienteEmailAndDebitosAberto(email, Boolean.TRUE.toString());
        debitos = validaValorPagamento(pagamento, debitos);
        List<DebitoDTO> debitoList = debitoService.updateStatusDebito(debitos);
        pagamento.setDebitoDTO(debitoList);

        Pagamento pagamentoRealizado = pagamentoRepository.save(pagamento);
        debitoService.updatePagamentoDebito(pagamentoRealizado, debitoList);
        return pagamentoRealizado;
    }

    @Override
    public List<Pagamento> findAll() {
        return pagamentoRepository.findAll();
    }


    private  List<Debito> validaValorPagamento(Pagamento pagamento, List<Debito> debitos) {
       List<Debito> debitosPagos = new ArrayList<>();
        BigDecimal valorTotal = BigDecimal.ZERO;

        for (Debito debito: debitos) {
           valorTotal = valorTotal.add(debito.getValor());

            if (pagamento.getValorPagamento().equals(debito.getValor())) {
                debitosPagos.add(debito);
            } else if (pagamento.getValorPagamento().equals(valorTotal)) {
                return debitos;
            }
        }


        return debitosPagos;
    }

}
