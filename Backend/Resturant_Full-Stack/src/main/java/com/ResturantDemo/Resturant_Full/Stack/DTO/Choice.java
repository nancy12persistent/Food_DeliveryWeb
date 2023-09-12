package com.ResturantDemo.Resturant_Full.Stack.DTO;

import lombok.Data;

@Data
public class Choice {
    public  int index;
    public Message message;

    public Choice(){}
    public Choice(int index, Message message) {
        this.index = index;
        this.message = message;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
