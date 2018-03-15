package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitcoinController {

    @Autowired
    CoinmarketcapClient coinmarketcapClient;

    @GetMapping("/price")
    public CoinmarketcapResponse getPriceFromCoinmarketcap() {
        return coinmarketcapClient.getPrice();
    }
}
