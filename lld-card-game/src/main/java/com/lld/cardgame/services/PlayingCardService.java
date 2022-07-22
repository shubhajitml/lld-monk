package com.lld.cardgame.services;

import com.lld.cardgame.entities.Card;
import com.lld.cardgame.entities.Suit;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PlayingCardService extends Card {
    private Suit suit;
    private int value;

    public static final Map<String, Integer> VALUES = new HashMap<>();

    static {
        VALUES.put("A", 1);
        for(int i = 2; i <= 10; ++i) {
            VALUES.put(String.valueOf(i), i);
        }
        VALUES.put("J", 11);
        VALUES.put("Q", 12);
        VALUES.put("K", 13);
    }
    // Inverts the above map to convert back to string.
    public static final Map<Integer, String> VALUE_NAMES = VALUES.entrySet().stream().collect(
            Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));


    public PlayingCardService(String suit, String value){
        this.suit = Suit.valueOf(suit.toUpperCase());
        this.value = VALUES.get(value);
    }

    @Override
    public String toString(){
        String stringValue = VALUE_NAMES.get(value)+" of "+this.suit.toString();
        return stringValue;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}

