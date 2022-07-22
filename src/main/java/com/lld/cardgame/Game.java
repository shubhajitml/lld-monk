package com.lld.cardgame;

import java.util.ArrayList;

import com.lld.cardgame.entities.Card;
import com.lld.cardgame.services.PlayingCardService;

public class Game {
    ArrayList<Card> cards;

    public Game(){
        cards = new ArrayList<>();
    }

    public void addCard(String suit, String value){
        cards.add(new PlayingCardService(suit, value));
    }

    public String cardString(int card){
        return cards.get(card).toString();
    }

    public boolean cardBeats(int cardA, int cardB){
        return cards.get(cardA).compareTo(cards.get(cardB)) > 0;
    }

}
