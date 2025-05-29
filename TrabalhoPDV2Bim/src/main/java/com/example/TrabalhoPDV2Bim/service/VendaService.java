package com.example.TrabalhoPDV2Bim.service;

import com.example.TrabalhoPDV2Bim.domain.Cliente;
import com.example.TrabalhoPDV2Bim.domain.Venda;
import com.example.TrabalhoPDV2Bim.repository.ClienteRepository;
import com.example.TrabalhoPDV2Bim.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda insert(Venda venda){
        return vendaRepository.save(venda);
    }

    public List<Venda> findAll(String nome){
        return vendaRepository.findAll();
    }

    public void delete(Long id){
        vendaRepository.deleteById(id);
    }

    public Venda update(Venda venda){
        return vendaRepository.save(venda);
    }

    public Venda findByIdOrThrow(Long id) {
        return vendaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Venda não encontrada com ID: " + id));
    }

}
