package com.bitCompra.bitCompra.clients;

import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoinmarketcapClientTest {

    String COIN_MARKET_URL = "https://api.coinmarketcap.com/v1/ticker/bitcoin/";

    @InjectMocks
    private CoinmarketcapClient coinmarketcapClient;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldGetPriceFromMarketCapApi() {

        CoinmarketcapResponse coin = new CoinmarketcapResponse("bitcoin", "9.91");
        CoinmarketcapResponse[] array = new CoinmarketcapResponse[]{coin};
        ResponseEntity<CoinmarketcapResponse[]> expectedResponse = new ResponseEntity<>(array, HttpStatus.OK);

        when(restTemplate.getForEntity(COIN_MARKET_URL, CoinmarketcapResponse[].class))
                .thenReturn(expectedResponse);

        CoinmarketcapResponse actualResponse = coinmarketcapClient.getPrice();
        assertThat(coin, is(actualResponse));

    }


}