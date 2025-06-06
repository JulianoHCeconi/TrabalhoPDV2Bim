package com.example.TrabalhoPDV2Bim.service;

import com.example.TrabalhoPDV2Bim.domain.ItemVenda;
import com.example.TrabalhoPDV2Bim.repository.ItemVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemVendaService {

    @Autowired
    private ItemVendaRepository itemVendaRepository;

    public ItemVenda insert(ItemVenda itemVenda){
        return itemVendaRepository.save(itemVenda);
    }

    public List<ItemVenda> findAll(Long vendaId, Long produtoId){
        return itemVendaRepository.findAll();
    }

    public void delete(Long id){
        itemVendaRepository.deleteById(id);
    }

    public ItemVenda update(ItemVenda itemVenda){
        return itemVendaRepository.save(itemVenda);
    }

}
