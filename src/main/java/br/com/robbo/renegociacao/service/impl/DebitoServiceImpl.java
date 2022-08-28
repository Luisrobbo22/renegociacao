package br.com.robbo.renegociacao.service.impl;

import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.Debito;
import br.com.robbo.renegociacao.entity.Pagamento;
import br.com.robbo.renegociacao.mapper.MapStructMapper;
import br.com.robbo.renegociacao.repository.DebitoRepository;
import br.com.robbo.renegociacao.service.DebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebitoServiceImpl implements DebitoService {

    @Autowired
    private DebitoRepository debitoRepository;

    @Override
    public List<Debito> getDebitoByEmailCliente(String email) {
        return debitoRepository.findDebitosByClienteEmail(email);
    }

    @Override
    public List<Debito> getDebitosByClienteEmailAndDebitosAberto(String email, String isDebitoAberto) {
        return debitoRepository.findDebitosByClienteEmailAndDebitosAbertoEqualsTrue(email);
    }

    @Override
    public List<DebitoDTO> updateStatusDebito(List<Debito> debitos) {
        debitos.forEach(d -> d.setDebitoAberto(Boolean.FALSE));
        List<Debito> debitoList = debitoRepository.saveAll(debitos);
        List<DebitoDTO> debitoDTOS = MapStructMapper.INSTANCE.dtosToDebitos(debitoList);

        return debitoDTOS;
    }

    public List<Debito> createDebito(List<Debito> debitos) {
        return debitoRepository.saveAll(debitos);
    }

    @Override
    public void updatePagamentoDebito(Pagamento pagamentoRealizado, List<DebitoDTO> dtos) {
        dtos.forEach(debitoDTO -> debitoRepository.updateIdPagamento(pagamentoRealizado.getId(), debitoDTO.getId()));
    }

}
