package br.com.robbo.renegociacao.repository;

import br.com.robbo.renegociacao.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {

}
