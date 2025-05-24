package com.example.TrabalhoPDV2Bim.repository;

import com.example.TrabalhoPDV2Bim.domain.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface VendaRepository extends JpaRepository<Venda, Long> {

    List<Venda> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);

}
