package com.bitCompra.bitCompra.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NoArgsConstructor;

public interface QueryResponseInterface {
    public String getPrice();
}
