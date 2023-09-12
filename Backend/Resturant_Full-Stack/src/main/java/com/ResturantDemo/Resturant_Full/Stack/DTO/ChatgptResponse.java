package com.ResturantDemo.Resturant_Full.Stack.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ChatgptResponse {
    public ChatgptResponse(List<Choice> choices) {
        this.choices = choices;
    }
    public ChatgptResponse(){}

    private List<Choice> choices;


    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }
}
