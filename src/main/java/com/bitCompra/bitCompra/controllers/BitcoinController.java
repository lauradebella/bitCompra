package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class BitcoinController {

    @Autowired
    CoinmarketcapClient coinmarketcapClient;

    @RequestMapping("/price")
    public Optional<CoinmarketcapResponse> getPriceFromCoinmarketcap() {
        return coinmarketcapClient.getPrice();
    }
}
