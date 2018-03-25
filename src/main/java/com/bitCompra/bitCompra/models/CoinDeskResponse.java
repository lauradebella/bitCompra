package com.bitCompra.bitCompra.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CoinDeskResponse implements QueryResponseInterface{

    private String name;
    private String price;

    @JsonCreator
    public CoinDeskResponse(@JsonProperty("chartName") String name,
                            @JsonProperty("bpi.USD.rate")String price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

}
