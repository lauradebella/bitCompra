package com.bitCompra.bitCompra.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CoinmarketcapResponse {

    private String name;
    private String price;

    @JsonCreator
    public CoinmarketcapResponse(@JsonProperty("name") String name,
                                 @JsonProperty("price_usd")String price_usd) {
        this.name = name;
        this.price = price_usd;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
