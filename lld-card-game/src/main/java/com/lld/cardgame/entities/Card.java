package com.lld.cardgame.entities;

public abstract class Card implements Comparable<Card>{
    public abstract int getValue();

    public int compareTo(Card o){
        return Integer.compare(getValue(), o.getValue());
    }
}
