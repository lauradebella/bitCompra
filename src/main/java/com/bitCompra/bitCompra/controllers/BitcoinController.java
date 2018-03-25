package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.clients.QueryClientInterface;
import com.bitCompra.bitCompra.entities.ConsultaPreco;
import com.bitCompra.bitCompra.models.QueryResponseInterface;
import com.bitCompra.bitCompra.repositories.ConsultaPrecoRepository;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class BitcoinController {

    private String DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    QueryClientInterface queryClient;
    private ConsultaPrecoRepository consultaPrecoRepository;

    public BitcoinController(QueryClientInterface queryClient, ConsultaPrecoRepository consultaPrecoRepository) {
        this.queryClient = queryClient;
        this.consultaPrecoRepository = consultaPrecoRepository;
    }

    @RequestMapping("/price")
    public QueryResponseInterface getPriceFromCoinmarketcap() {
        QueryResponseInterface response = queryClient.getPrice();

        ConsultaPreco consultaPreco = new ConsultaPreco();
        consultaPreco.setFonte("CoinmarketCap");
        String horario =  new SimpleDateFormat(DATE_TIME_FORMAT).format(new Date());
        consultaPreco.setHorario(horario);
        consultaPreco.setPreco("U$" + response.getPrice());

        consultaPrecoRepository.save(consultaPreco);

        return response;
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<ConsultaPreco> getAllUsers() {
        return consultaPrecoRepository.findAll();
    }

}

