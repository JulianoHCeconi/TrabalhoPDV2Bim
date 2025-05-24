package com.example.TrabalhoPDV2Bim.repository;

import com.example.TrabalhoPDV2Bim.domain.Cliente;
import com.example.TrabalhoPDV2Bim.domain.Produto;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByNomeContaining(String nome);

}
