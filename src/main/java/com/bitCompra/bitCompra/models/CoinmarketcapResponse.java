package com.bitCompra.bitCompra.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinmarketcapResponse {
    private String name;
    private String price_usd;
}
