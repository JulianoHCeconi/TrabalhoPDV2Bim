package com.example.TrabalhoPDV2Bim.controller;

import com.example.TrabalhoPDV2Bim.service.ClienteService;
import com.example.TrabalhoPDV2Bim.service.ProdutoService;
import org.springframework.ui.Model;
import com.example.TrabalhoPDV2Bim.domain.Cliente;
import com.example.TrabalhoPDV2Bim.domain.ItemVenda;
import com.example.TrabalhoPDV2Bim.domain.Produto;
import com.example.TrabalhoPDV2Bim.domain.Venda;
import com.example.TrabalhoPDV2Bim.dto.ItemVendaDTO;
import com.example.TrabalhoPDV2Bim.dto.ProdutoRequestDTO;
import com.example.TrabalhoPDV2Bim.dto.VendaRequestDTO;
import com.example.TrabalhoPDV2Bim.repository.ClienteRepository;
import com.example.TrabalhoPDV2Bim.repository.ProdutoRepository;
import com.example.TrabalhoPDV2Bim.repository.VendaRepository;
import com.example.TrabalhoPDV2Bim.service.VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/vendas")
public class VendaController {

    @Autowired
    private VendaService vendaService;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Venda> insert(@RequestBody @Valid VendaRequestDTO vendaRequestDTO){

        Cliente cliente = clienteService.findByIdOrThrow(vendaRequestDTO.getClienteId());

        List<ItemVenda> itens = new ArrayList<>();

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setData(LocalDateTime.now());
        venda.setObservacoes(vendaRequestDTO.getObservacoes());

        double total = 0.0;
        for (ItemVendaDTO itemVendaDTO : vendaRequestDTO.getItens()){
            Produto produto = produtoService.findByIdOrThrow(itemVendaDTO.getProdutoId());

            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(produto);
            itemVenda.setQuantidade(itemVendaDTO.getQuantidade());
            itemVenda.setValorUnitario(produto.getValor());
            itemVenda.setValorTotal(produto.getValor() * itemVendaDTO.getQuantidade());
            itemVenda.setVenda(venda);

            itens.add(itemVenda);
            total += itemVenda.getValorTotal();
        }

        venda.setItens(itens);
        venda.setTotal(total);
        Venda salvarVenda = vendaService.insert(venda);
        return ResponseEntity.ok(salvarVenda);

    }


}
