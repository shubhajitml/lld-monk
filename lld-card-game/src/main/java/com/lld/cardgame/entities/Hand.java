package com.lld.cardgame.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand implements Comparable<Hand>{
    public ArrayList<Card> cards;

    public Hand(List<Card> cards){
        this.cards = new ArrayList<>(cards);
    }

    @Override
    public int compareTo(Hand o) {
        ArrayList<Card> selfCards = new ArrayList<>(cards);
        ArrayList<Card> otherCards = new ArrayList<>(o.cards);
        Collections.sort(selfCards);
        Collections.sort(otherCards);
        for(int i = selfCards.size()-1, j = otherCards.size()-1; i >= 0 && j >= 0; --i, --j){
            int res = selfCards.get(i).compareTo(otherCards.get(j));
            if(res != 0) return res;
        }
        return 0;
    }

}
