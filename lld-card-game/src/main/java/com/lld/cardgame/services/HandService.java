package com.lld.cardgame.services;

import com.lld.cardgame.entities.Card;
import com.lld.cardgame.entities.Hand;

import java.util.List;
import java.util.stream.Collectors;

public class HandService extends Hand {
    public HandService(List<Card> cards) {
        super(cards);
    }

    @Override
    public String toString(){
        return cards.stream().map(String::valueOf).collect(Collectors.joining(", "));
    }
}
