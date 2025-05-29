package com.example.TrabalhoPDV2Bim.controller;

import com.example.TrabalhoPDV2Bim.domain.ItemVenda;
import com.example.TrabalhoPDV2Bim.domain.Produto;
import com.example.TrabalhoPDV2Bim.domain.Venda;
import com.example.TrabalhoPDV2Bim.dto.ItemVendaDTO;
import com.example.TrabalhoPDV2Bim.repository.ItemVendaRepository;
import com.example.TrabalhoPDV2Bim.repository.ProdutoRepository;
import com.example.TrabalhoPDV2Bim.repository.VendaRepository;
import com.example.TrabalhoPDV2Bim.service.ItemVendaService;
import com.example.TrabalhoPDV2Bim.service.ProdutoService;
import com.example.TrabalhoPDV2Bim.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item_venda")
public class ItemVendaController {

    @Autowired
    private ItemVendaService itemVendaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<ItemVenda> insert(@RequestBody @Valid ItemVendaDTO itemVendaDTO){

        Produto produto = produtoService.findByIdOrThrow(itemVendaDTO.getProdutoId());
        Venda venda = vendaService.findByIdOrThrow(itemVendaDTO.getVendaId());

        ItemVenda itemVenda = new ItemVenda();
        itemVenda.setProduto(produto);
        itemVenda.setQuantidade(itemVendaDTO.getQuantidade());
        itemVenda.setValorUnitario(produto.getValor());
        itemVenda.setValorTotal(produto.getValor() * itemVendaDTO.getQuantidade());
        itemVenda.setVenda(venda);

        ItemVenda salvo = itemVendaService.insert(itemVenda);

        return ResponseEntity.ok(salvo);

    }

}
