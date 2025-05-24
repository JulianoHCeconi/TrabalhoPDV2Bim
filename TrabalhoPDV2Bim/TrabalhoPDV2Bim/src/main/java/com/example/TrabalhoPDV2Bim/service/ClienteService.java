package com.example.TrabalhoPDV2Bim.service;

import com.example.TrabalhoPDV2Bim.domain.Cliente;
import com.example.TrabalhoPDV2Bim.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(String nome){
        return clienteRepository.findAll();
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }

    public Cliente update(Cliente cliente){
        return clienteRepository.save(cliente);
    }

}
