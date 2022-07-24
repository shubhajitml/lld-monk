package com.lld.cardgame;

import java.util.ArrayList;
import java.util.List;

import com.lld.cardgame.entities.Card;
import com.lld.cardgame.entities.Hand;
import com.lld.cardgame.services.AddJokerService;
import com.lld.cardgame.services.HandService;
import com.lld.cardgame.services.PlayingCardService;

public class Game {
    ArrayList<Card> cards;
    ArrayList<Hand> hands;

    public Game(){
        cards = new ArrayList<>();
        hands = new ArrayList<>();
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

    public void addJoker(String color){
        cards.add(new AddJokerService(color));
    }

    public void addHand(List<Integer> cardIndices){
        ArrayList<Card> cardObjects = new ArrayList<>();
        for(int i : cardIndices){
            cardObjects.add(cards.get(i));
        }
        hands.add(new HandService(cardObjects));
    }

    public String handString(int handIndice){
        return hands.get(handIndice).toString();
    }

    public boolean handBeats(int handA, int handB){
        return hands.get(handA).compareTo(hands.get(handB)) > 0;
    }
}
