package br.com.robbo.renegociacao.controller;

import br.com.robbo.renegociacao.entity.Cliente;
import br.com.robbo.renegociacao.repository.ClienteRepository;
import br.com.robbo.renegociacao.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/{email}")
    public ResponseEntity<Cliente> getClienteByEmail(@PathVariable String email) {
        final Cliente cliente = clienteService.getClienteByEmail(email);
        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> getAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok().body(clientes);
    }

    @PostMapping("/new")
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        final Cliente clienteCriado = clienteService.createCliente(cliente);
        return ResponseEntity.ok().body(clienteCriado);
    }

}
