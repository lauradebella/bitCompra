package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.entities.ConsultaPreco;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import com.bitCompra.bitCompra.repositories.ConsultaPrecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
public class BitcoinController {

    private String dateTimeFormat = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    CoinmarketcapClient coinmarketcapClient;

    @Autowired
    private ConsultaPrecoRepository consultaPrecoRepository;

    @RequestMapping("/price")
    public Optional<CoinmarketcapResponse> getPriceFromCoinmarketcap() {
        Optional<CoinmarketcapResponse> consultaCoinMarketcap = coinmarketcapClient.getPrice();

        ConsultaPreco consultaPreco = new ConsultaPreco();
        consultaPreco.setFonte("CoinmarketCap");
        String horario =  new SimpleDateFormat(dateTimeFormat).format(new Date());
        consultaPreco.setHorario(horario);
        consultaPreco.setPreco("U$"consultaCoinMarketcap.get().getPrice());

        consultaPrecoRepository.save(consultaPreco);

        return consultaCoinMarketcap;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ConsultaPreco> getAllUsers() {
        return consultaPrecoRepository.findAll();
    }

}

