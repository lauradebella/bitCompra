package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class BitcoinControllerTest {

    @InjectMocks //inject mocked objects inside this class
    BitcoinController bitcoinController;

    @Mock
    CoinmarketcapClient coinmarketcapClient;

    @Test
    public void shouldGetPriceFromCoinmarketcap (){
        String coinPrice = "91.00";
        String coinName = "bitcoin";
        CoinmarketcapResponse expectedResponse = new CoinmarketcapResponse(coinName, coinPrice);

        when(coinmarketcapClient.getPrice()).thenReturn(expectedResponse);

        CoinmarketcapResponse actualResponse = bitcoinController.getPriceFromCoinmarketcap();

        assertThat(actualResponse, is(expectedResponse));
    }
    
}