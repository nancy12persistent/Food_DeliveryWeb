package com.ResturantDemo.Resturant_Full.Stack.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ChatgptConfig {

    @Value("${openai.api.key}")
    String openAPiKey;

    @Bean
    public RestTemplate template(){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.getInterceptors().add((request, body, execution) -> {
            request.getHeaders().add("Authorization", "Bearer " + openAPiKey);
            return execution.execute(request, body);
        });
        return restTemplate;
    }
}