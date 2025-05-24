package com.example.TrabalhoPDV2Bim.controller;

import com.example.TrabalhoPDV2Bim.domain.Item_Venda;
import com.example.TrabalhoPDV2Bim.dto.ItemVendaDTO;
import com.example.TrabalhoPDV2Bim.service.Item_VendaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/item_venda")
public class Item_VendaController {

    @Autowired
    private Item_VendaService item_vendaService;

    @PostMapping
    public ResponseEntity<Item_Venda> insert(@RequestBody @Valid ItemVendaDTO itemVendaDTO,
                                             UriComponentsBuilder builder){

        Item_Venda itemVenda = new Item_Venda(itemVendaDTO);
        itemVenda = item_vendaService.insert(itemVenda);

        URI uri = builder.path("/item_venda/{id}").
                buildAndExpand(itemVenda.getId()).toUri();
        return ResponseEntity.created(uri).body(itemVenda);

    }

    @GetMapping
    public ResponseEntity<List<Item_Venda>> findAll(
            @RequestParam(value = "venda", required = false) Long venda,
            @RequestParam(value = "produto", required = false) Long produto){

        List<Item_Venda> retorno = item_vendaService.findAll(venda, produto);
        return ResponseEntity.ok(retorno);

    }

    @PutMapping
    public ResponseEntity<Item_Venda> update(@PathVariable Long id,
                                             @RequestBody @Valid ItemVendaDTO itemVendaDTO){

        Item_Venda itemVenda = new Item_Venda(id, itemVendaDTO);
        itemVenda = item_vendaService.update(itemVenda);
        return ResponseEntity.ok(itemVenda);

    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
        item_vendaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
