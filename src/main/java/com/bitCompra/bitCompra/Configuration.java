package com.bitCompra.bitCompra;

import com.bitCompra.bitCompra.clients.CoinmarketcapClient;
import com.bitCompra.bitCompra.clients.QueryClientInterface;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@org.springframework.context.annotation.Configuration
public class Configuration {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean("queryClient")
    public QueryClientInterface queryClient() {
        Random rand = new Random();

        int n = rand.nextInt(1);
//        if (n == 1){
//            return new CoinDeskClient(new RestTemplate());
//        }else{
            return new CoinmarketcapClient(new RestTemplate());
        //}
    }
}
