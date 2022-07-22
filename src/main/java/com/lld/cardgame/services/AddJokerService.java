package com.lld.cardgame.services;

import com.lld.cardgame.entities.Card;
import com.lld.cardgame.entities.JokerColor;

public class AddJokerService extends Card {
    private JokerColor color;

    public AddJokerService(String color){
        this.color = JokerColor.valueOf(color.toUpperCase());
    }

    @Override
    public String toString(){
        return this.color+" Joker";
    }

    @Override
    public int getValue() {
        return 14;
    }
}
