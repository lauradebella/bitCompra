package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinDeskClient;
import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.entities.ConsultaPreco;
import com.bitCompra.bitCompra.models.CoinDeskResponse;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import com.bitCompra.bitCompra.repositories.ConsultaPrecoRepository;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@RestController
public class BitcoinController {

    private String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    CoinmarketcapClient coinmarketcapClient;
    CoinDeskClient coinDeskClient;

    private ConsultaPrecoRepository consultaPrecoRepository;

    public BitcoinController(CoinmarketcapClient coinmarketcapClient,
                             CoinDeskClient coinDeskClient,
                             ConsultaPrecoRepository consultaPrecoRepository) {
        this.coinmarketcapClient = coinmarketcapClient;
        this.coinDeskClient = coinDeskClient;
        this.consultaPrecoRepository = consultaPrecoRepository;
    }

    @RequestMapping("/price")
    public CoinmarketcapResponse getPriceFromCoinmarketcap() {
        CoinmarketcapResponse consultaCoinMarketcap = coinmarketcapClient.getPrice();

        ConsultaPreco consultaPreco = new ConsultaPreco();
        consultaPreco.setFonte("CoinmarketCap");
        String horario =  new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date());
        consultaPreco.setHorario(horario);
        consultaPreco.setPreco("U$" + consultaCoinMarketcap.getPrice());

        consultaPrecoRepository.save(consultaPreco);

        return consultaCoinMarketcap;
    }

    @GetMapping("/teste")
    public CoinDeskResponse getPriceFromCoinDesk() {
        CoinDeskResponse consultaCoinDesk = coinDeskClient.getPrice();

        ConsultaPreco consultaPreco = new ConsultaPreco();
        consultaPreco.setFonte("CoinDesk");
        String horario =  new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date());
        consultaPreco.setHorario(horario);
        consultaPreco.setPreco("U$" + consultaCoinDesk.getPrice());

        consultaPrecoRepository.save(consultaPreco);

        return consultaCoinDesk;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ConsultaPreco> getAllUsers() {
        return consultaPrecoRepository.findAll();
    }

}

