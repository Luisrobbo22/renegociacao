package br.com.robbo.renegociacao.controller;

import br.com.robbo.renegociacao.entity.Pagamento;
import br.com.robbo.renegociacao.service.PagamentoService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pagamento")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping("/new/{email}")
    public ResponseEntity<Pagamento> createPagamento(@PathVariable @NotNull String email , @RequestBody Pagamento pagamento) {

        Pagamento pagamentoCriado = pagamentoService.createPagamento(pagamento, email);
        return ResponseEntity.accepted().body(pagamentoCriado);
    }
}
