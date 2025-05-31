package com.example.TrabalhoPDV2Bim.controller;


import com.example.TrabalhoPDV2Bim.domain.Cliente;
import com.example.TrabalhoPDV2Bim.domain.Produto;
import com.example.TrabalhoPDV2Bim.dto.ProdutoRequestDTO;
import com.example.TrabalhoPDV2Bim.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody @Valid ProdutoRequestDTO produtoRequestDTO,
                                          UriComponentsBuilder builder){

        Produto produto = new Produto(produtoRequestDTO);
        produto = produtoService.insert(produto);

        URI uri = builder.path("/produtos/{id}").
                buildAndExpand(produto.getId()).toUri();

        return ResponseEntity.created(uri).body(produto);

    }

    @GetMapping
    public ResponseEntity<List<Produto>> findAll(
            @RequestParam(value = "nome", required = false) String nome){

        List<Produto> retorno = produtoService.findAll(nome);
        return ResponseEntity.ok(retorno);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Produto produto = produtoService.findById(id).orElse(null);

        if (produto != null) {
            return ResponseEntity.ok(produto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id,
                                          @RequestBody @Valid ProdutoRequestDTO produtoRequestDTO){

        Produto produto = new Produto(id, produtoRequestDTO);
        produto = produtoService.update(produto);
        return ResponseEntity.ok(produto);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        produtoService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
