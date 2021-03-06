package com.bitCompra.bitCompra.controllers;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.clients.QueryClientInterface;
import com.bitCompra.bitCompra.entities.ConsultaPreco;
import com.bitCompra.bitCompra.models.CoinmarketcapResponse;
import com.bitCompra.bitCompra.models.QueryResponseInterface;
import com.bitCompra.bitCompra.repositories.ConsultaPrecoRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

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
    QueryClientInterface queryClientInterface;

    @Mock
    ConsultaPrecoRepository consultaPrecoRepository;

    @Test
    public void shouldGetPriceFromCoinmarketcapAndSaveInDatabase (){
        String coinPrice = "91.00";
        String coinName = "bitcoin";
        QueryResponseInterface expectedResponse = new CoinmarketcapResponse(coinName, coinPrice);

        when(queryClientInterface.getPrice()).thenReturn(expectedResponse);

        QueryResponseInterface actualResponse = bitcoinController.getPriceFromCoinmarketcap();
        verify(consultaPrecoRepository, times(1)).save(any());

        assertThat(actualResponse, is(expectedResponse));
    }
    
}