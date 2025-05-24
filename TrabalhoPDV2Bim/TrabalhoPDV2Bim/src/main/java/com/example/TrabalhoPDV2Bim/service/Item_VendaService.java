package com.example.TrabalhoPDV2Bim.service;

import com.example.TrabalhoPDV2Bim.domain.Item_Venda;
import com.example.TrabalhoPDV2Bim.domain.Venda;
import com.example.TrabalhoPDV2Bim.repository.Item_VendaRepository;
import com.example.TrabalhoPDV2Bim.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Item_VendaService {

    @Autowired
    private Item_VendaRepository item_vendaRepository;

    public Item_Venda insert(Item_Venda itemVenda){
        return item_vendaRepository.save(itemVenda);
    }

    public List<Item_Venda> findAll(Long id, Long produto){
        return item_vendaRepository.findAll();
    }

    public void delete(Long id){
        item_vendaRepository.deleteById(id);
    }

    public Item_Venda update(Item_Venda itemVenda){
        return item_vendaRepository.save(itemVenda);
    }

}
