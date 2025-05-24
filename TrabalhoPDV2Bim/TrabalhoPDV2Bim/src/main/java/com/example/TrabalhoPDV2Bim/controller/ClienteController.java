package com.example.TrabalhoPDV2Bim.controller;


import com.example.TrabalhoPDV2Bim.domain.Cliente;
import com.example.TrabalhoPDV2Bim.dto.ClienteRequestDTO;
import com.example.TrabalhoPDV2Bim.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> insert(@RequestBody @Valid ClienteRequestDTO clienteRequestDTO,
                                                UriComponentsBuilder builder) {

        Cliente cliente = new Cliente(clienteRequestDTO);
        cliente = clienteService.insert(cliente);

        URI uri = builder.path("/clientes/{id}").
                buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(cliente);

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(@RequestParam(value = "nome", required = false) String nome){
        List<Cliente> retorno = clienteService.findAll(nome);
        return ResponseEntity.ok(retorno);
    }

    @PutMapping("{id}")
    public ResponseEntity<Cliente> update(@PathVariable Long id,
                                          @RequestBody @Valid ClienteRequestDTO clienteRequestDTO){

        Cliente cliente = new Cliente(id, clienteRequestDTO);

        cliente = clienteService.update(cliente);
        return ResponseEntity.ok(cliente);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
