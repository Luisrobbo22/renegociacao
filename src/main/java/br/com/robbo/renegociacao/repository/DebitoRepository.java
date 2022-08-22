package br.com.robbo.renegociacao.repository;

import br.com.robbo.renegociacao.entity.Debito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DebitoRepository extends JpaRepository<Debito, Integer> {

    List<Debito> findDebitosByClienteEmail(String email);
}
