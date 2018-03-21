package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.entities.ConsultaPreco;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import com.bitCompra.bitCompra.repositories.ConsultaPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class BitcoinController {

    @Autowired
    CoinmarketcapClient coinmarketcapClient;

    @Autowired
    private ConsultaPrecoRepository consultaPrecoRepository;

    @RequestMapping("/price")
    public Optional<CoinmarketcapResponse> getPriceFromCoinmarketcap() {
        return coinmarketcapClient.getPrice();
    }

    @GetMapping(path="/addConsulta")
    public @ResponseBody
    String addNewConsulta (@RequestParam String fonte, @RequestParam String preco, @RequestParam String horario){
        ConsultaPreco consultaPreco = new ConsultaPreco();
        consultaPreco.setFonte(fonte);
        consultaPreco.setHorario(horario);
        consultaPreco.setPreco(preco);

        consultaPrecoRepository.save(consultaPreco);

        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ConsultaPreco> getAllUsers() {
        return consultaPrecoRepository.findAll();
    }

}

