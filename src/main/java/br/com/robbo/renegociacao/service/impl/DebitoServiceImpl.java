package br.com.robbo.renegociacao.service.impl;

import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.Debito;
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
    public List<DebitoDTO> updateStatusDebito(List<Debito> debitos) {
        debitos.forEach(d -> d.setDebitoAberto(Boolean.FALSE));
        List<Debito> debitoList = debitoRepository.saveAll(debitos);
        List<DebitoDTO> debitoDTOS = MapStructMapper.INSTANCE.dtosToDebitos(debitoList);

        return debitoDTOS;
    }

    public List<Debito> createDebito(List<Debito> debitos) {
        return debitoRepository.saveAll(debitos);
    }

//    private List<DebitoDTO> mapperDebitos(List<Debito> debitos) {
//        List<DebitoDTO> debitoDTOS = new ArrayList<>();
//        for (int i = 0; i < debitos.size(); i++) {
//            debitoDTOS.debitos.get(i).getCliente();
//
//        }
//
//
//        for (Debito debito: debitos) {
//            debitoDTOS.forEach(debitoDTO -> {
//                debitoDTO.setVencimento(debito.getVencimento());
//                debitoDTO.setDebitoAberto(debito.isDebitoAberto());
//                debitoDTO.setValor(debito.getValor());
//                debitoDTO.setDescricaoDebito(debito.getDescricaoDebito());
//            });
//        }
//
//        return debitoDTOS;
//    }

}
