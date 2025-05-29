package com.example.TrabalhoPDV2Bim.repository;


import com.example.TrabalhoPDV2Bim.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    public List<Cliente> findAllByNomeContaining(String nome);

}
