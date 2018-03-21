package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.entities.ConsultaPreco;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import com.bitCompra.bitCompra.repositories.ConsultaPrecoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BitcoinControllerTest {

    @InjectMocks //inject mocked objects inside this class
    BitcoinController bitcoinController;

    @Mock
    CoinmarketcapClient coinmarketcapClient;

    @Mock
    ConsultaPrecoRepository consultaPrecoRepository;

    @Test
    public void shouldGetPriceFromCoinmarketcapAndSaveInDatabase (){
        String coinPrice = "91.00";
        String coinName = "bitcoin";
        Optional<CoinmarketcapResponse> expectedResponse = Optional.of(new CoinmarketcapResponse(coinName, coinPrice));

        when(coinmarketcapClient.getPrice()).thenReturn(expectedResponse);

        Optional<CoinmarketcapResponse> actualResponse = bitcoinController.getPriceFromCoinmarketcap();
        verify(consultaPrecoRepository, times(1)).save(any());

        assertThat(actualResponse, is(expectedResponse));
    }
    
}