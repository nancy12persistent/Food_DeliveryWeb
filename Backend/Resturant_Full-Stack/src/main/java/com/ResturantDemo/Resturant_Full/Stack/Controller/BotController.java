package com.ResturantDemo.Resturant_Full.Stack.Controller;


import com.ResturantDemo.Resturant_Full.Stack.DTO.ChatgptRequest;
import com.ResturantDemo.Resturant_Full.Stack.DTO.ChatgptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("/bot")
@CrossOrigin
public class BotController {

    @Value("${openai.model}")
    private  String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt){
        ChatgptRequest request= new ChatgptRequest(model,prompt);
        ChatgptResponse chatgptResponse=template.postForObject(apiURL,request,ChatgptResponse.class);
        return chatgptResponse.getChoices().get(0).getMessage().getContent();
        
    }

}
