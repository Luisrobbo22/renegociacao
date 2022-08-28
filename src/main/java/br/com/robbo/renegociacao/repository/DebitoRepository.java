package br.com.robbo.renegociacao.repository;

import br.com.robbo.renegociacao.entity.Debito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DebitoRepository extends JpaRepository<Debito, Integer> {

    List<Debito> findDebitosByClienteEmail(String email);

    @Query(value = "SELECT d FROM Debito d WHERE d.cliente.email = ?1 and d.isDebitoAberto = true")
    List<Debito> findDebitosByClienteEmailAndDebitosAbertoEqualsTrue(String email);


    @Modifying
    @Transactional
    @Query("update Debito d set d.pagamento.id =:idPagamento where d.id =:idDebito")
    void updateIdPagamento(@Param(value = "idPagamento") Integer pagamentoId, @Param(value = "idDebito") Integer idDebito);

}
