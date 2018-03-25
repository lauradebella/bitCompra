package com.bitCompra.bitCompra.clients;

import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinmarketcapClient {

    String COIN_MARKET_URL = "https://api.coinmarketcap.com/v1/ticker/bitcoin/";

    @Autowired
    RestTemplate restTemplate;

    public CoinmarketcapResponse getPrice() {
        ResponseEntity<CoinmarketcapResponse[]> responseEntity = restTemplate.getForEntity(COIN_MARKET_URL, CoinmarketcapResponse[].class);
        if(responseEntity.getStatusCode() != HttpStatus.OK){
            return null;
        }
        return responseEntity.getBody()[0];
    }
}
