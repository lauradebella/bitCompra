package com.bitCompra.bitCompra.clients;

import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinmarketcapClient {

    String COIN_MARKET_URL = "https://api.coinmarketcap.com/v1/ticker/biztcoin/";

    @Autowired
    RestTemplate restTemplate;

    public CoinmarketcapResponse getPrice() {
        return restTemplate.getForObject(
                COIN_MARKET_URL, CoinmarketcapResponse.class);
    }
}
