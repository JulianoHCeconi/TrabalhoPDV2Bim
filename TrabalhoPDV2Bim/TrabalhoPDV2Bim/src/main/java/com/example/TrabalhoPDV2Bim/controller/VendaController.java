package com.example.TrabalhoPDV2Bim.controller;

import com.example.TrabalhoPDV2Bim.domain.Produto;
import com.example.TrabalhoPDV2Bim.domain.Venda;
import com.example.TrabalhoPDV2Bim.dto.ProdutoRequestDTO;
import com.example.TrabalhoPDV2Bim.dto.VendaRequestDTO;
import com.example.TrabalhoPDV2Bim.repository.ClienteRepository;
import com.example.TrabalhoPDV2Bim.repository.ProdutoRepository;
import com.example.TrabalhoPDV2Bim.repository.VendaRepository;
import com.example.TrabalhoPDV2Bim.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<Venda> update(@RequestBody @Valid VendaRequestDTO vendaRequestDTO,
                                        UriComponentsBuilder builder){

        Venda venda = new Venda(vendaRequestDTO);
        venda = vendaRepository.save(venda);

        URI uri = builder.path("/vendas/{id}").
                buildAndExpand(venda.getId()).toUri();
        return ResponseEntity.created(uri).body(venda);

    }

    @GetMapping
    public ResponseEntity<List<Venda>> findAll(
            @RequestParam(value = "cliente", required = false) String cliente){
        List<Venda> retorno = vendaRepository.findAll();

        return ResponseEntity.ok(retorno);
    }

    @PutMapping
    public ResponseEntity<Venda> update(@PathVariable Long id,
                                        @RequestBody @Valid VendaRequestDTO vendaRequestDTO){

        Venda venda = new Venda(id, vendaRequestDTO);
        venda = vendaService.update(venda);
        return ResponseEntity.ok(venda);
    }


}
