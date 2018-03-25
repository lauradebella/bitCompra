package com.bitCompra.bitCompra.clients;

import com.bitCompra.bitCompra.models.CoinDeskResponse;
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
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CoinDeskClientTest {

    String COIN_MARKET_URL = "https://api.coindesk.com/v1/bpi/currentprice.json";

    @InjectMocks
    private CoinDeskClient coinDeskClient;

    @Mock
    private RestTemplate restTemplate;

    @Test
    public void shouldGetPriceFromCoinDeskApi() {

        CoinDeskResponse coin = new CoinDeskResponse("bitcoin", "9.91");
        CoinDeskResponse[] array = new CoinDeskResponse[]{coin};
        ResponseEntity<CoinDeskResponse[]> expectedResponse = new ResponseEntity<>(array, HttpStatus.OK);

        when(restTemplate.getForEntity(COIN_MARKET_URL, CoinDeskResponse[].class))
                .thenReturn(expectedResponse);

        CoinDeskResponse actualResponse = coinDeskClient.getPrice();
        assertThat(coin, is(actualResponse));

    }


}