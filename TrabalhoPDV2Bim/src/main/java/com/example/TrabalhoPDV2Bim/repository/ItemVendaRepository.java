package com.example.TrabalhoPDV2Bim.repository;


import com.example.TrabalhoPDV2Bim.domain.ItemVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {



}
