package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BitcoinController {

    @Autowired
    CoinmarketcapClient coinmarketcapClient;

    public CoinmarketcapResponse getPriceFromCoinmarketcap() {
        return coinmarketcapClient.getPrice();
    }
}
