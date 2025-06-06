package com.example.TrabalhoPDV2Bim.service;

import com.example.TrabalhoPDV2Bim.domain.Produto;
import com.example.TrabalhoPDV2Bim.repository.ClienteRepository;
import com.example.TrabalhoPDV2Bim.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto insert(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> findAll(String nome){
        return produtoRepository.findAll();
    }

    public void delete(Long id){
        produtoRepository.deleteById(id);
    }

    public Produto update(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto findByIdOrThrow(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com ID: " + id));
    }

}
