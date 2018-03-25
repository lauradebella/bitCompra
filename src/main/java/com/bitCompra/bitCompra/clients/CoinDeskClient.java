package com.bitCompra.bitCompra.clients;

import com.bitCompra.bitCompra.models.CoinDeskResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class CoinDeskClient implements QueryClientInterface{

    String COIN_MARKET_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    RestTemplate restTemplate;

    public CoinDeskClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public CoinDeskResponse getPrice() {
        ResponseEntity<CoinDeskResponse[]> responseEntity = restTemplate.getForEntity(COIN_MARKET_URL, CoinDeskResponse[].class);
        if(responseEntity.getStatusCode() != HttpStatus.OK){
            return null;
        }
        return responseEntity.getBody()[0];
    }
}
