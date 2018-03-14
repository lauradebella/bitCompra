package com.bitCompra.bitCompra.clients;

import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoinmarketcapClientTest {

    String COIN_MARKET_URL = "https://api.coinmarketcap.com/v1/ticker/biztcoin/";

    @InjectMocks
    private CoinmarketcapClient coinmarketcapClient;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldGetPriceFromMarketCapApi() {

        CoinmarketcapResponse expectedResponse = new CoinmarketcapResponse("bitcoin", "9.91");
        when(restTemplate.getForObject(COIN_MARKET_URL, CoinmarketcapResponse.class)).thenReturn(expectedResponse);

        CoinmarketcapResponse actualResponse = coinmarketcapClient.getPrice();
        assertThat(expectedResponse, is(actualResponse));

    }


}