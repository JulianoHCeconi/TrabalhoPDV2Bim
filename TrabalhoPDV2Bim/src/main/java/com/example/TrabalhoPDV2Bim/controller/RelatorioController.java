package com.example.TrabalhoPDV2Bim.controller;


import com.example.TrabalhoPDV2Bim.domain.Venda;
import com.example.TrabalhoPDV2Bim.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class RelatorioController {

    @Autowired
    private VendaRepository vendaRepository;

    @GetMapping("/relatorio")
    public String vendasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fim,
            Model model){

        LocalDateTime dataInicio = inicio.atStartOfDay();
        LocalDateTime dataFim = fim.atTime(23, 59, 59);

        List<Venda> vendas = vendaRepository.findByDataBetween(dataInicio, dataFim);


        model.addAttribute("vendas", vendas);
        return "relatorioVendas";

    }

}
