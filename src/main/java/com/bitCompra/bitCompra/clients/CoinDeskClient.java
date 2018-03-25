package com.bitCompra.bitCompra.clients;

import com.bitCompra.bitCompra.models.CoinDeskResponse;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinDeskClient {

    String COIN_MARKET_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @Autowired
    RestTemplate restTemplate;

    public CoinDeskResponse getPrice() {
        ResponseEntity<CoinDeskResponse[]> responseEntity = restTemplate.getForEntity(COIN_MARKET_URL, CoinDeskResponse[].class);
        if(responseEntity.getStatusCode() != HttpStatus.OK){
            return null;
        }
        return responseEntity.getBody()[0];
    }
}
