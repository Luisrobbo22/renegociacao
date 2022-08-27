package br.com.robbo.renegociacao.controller;

import br.com.robbo.renegociacao.entity.Debito;
import br.com.robbo.renegociacao.service.DebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/debito")
public class DebitoController {

    @Autowired
    private DebitoService debitoService;

    @GetMapping("/{email}")
    public ResponseEntity<List<Debito>> getDebitosByEmailCliente(@PathVariable String email) {
        final List<Debito> debitos = debitoService.getDebitoByEmailCliente(email);

        return ResponseEntity.ok().body(debitos);
    }

    @PostMapping("/new")
    public ResponseEntity<List<Debito>> createDebito(@RequestBody List<Debito> debitos) {
        final List<Debito> debitosCriado = debitoService.createDebito(debitos);
        return ResponseEntity.accepted().body(debitosCriado);
    }
}
