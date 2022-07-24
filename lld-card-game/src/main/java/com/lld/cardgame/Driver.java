package com.lld.cardgame;

import java.util.ArrayList;

public class Driver {
    public static void main(String[] args){
        Game game = new Game();
//        String suit = "Spades", value = "Q";
//        if(suit == "Joker") game.addJoker(value);
//        else game.addCard(suit, value);
//        System.out.println(game.cardString(0));
//
//        suit = "Hearts"; value = "K";
//        if(suit == "Joker") game.addJoker(value);
//        else game.addCard(suit, value);
//        System.out.println(game.cardString(1));
//        System.out.println(game.cardString(0)+" beats> "+game.cardString(1)+": "+game.cardBeats(0,1));
//
//        suit = "Joker"; value = "red";
//        if(suit == "Joker") game.addJoker(value);
//        else game.addCard(suit, value);
//        System.out.println(game.cardString(2));
//        System.out.println(game.cardString(0)+" beats> "+game.cardString(2)+": "+game.cardBeats(0,2));
//        System.out.println(game.cardString(2)+" beats> "+game.cardString(1)+": "+game.cardBeats(2,1));
//        System.out.println(game.cardString(2)+" beats> "+game.cardString(0)+": "+game.cardBeats(2,0));
//
//        suit = "Joker"; value = "blAck";
//        if(suit == "Joker") game.addJoker(value);
//        else game.addCard(suit, value);
//        System.out.println(game.cardString(3));
//        System.out.println(game.cardString(3)+" beats> "+game.cardString(2)+": "+game.cardBeats(3,2));
//        System.out.println(game.cardString(2)+" beats> "+game.cardString(3)+": "+game.cardBeats(2,3));
        String suit = "", value = "";
        ArrayList<Integer> handAList = new ArrayList<>();
        int listALength = 5;
        for(int i = 0; i < listALength; ++i){
            if(i == 0) { suit = "Joker"; value = "red"; }
            else { suit = "Clubs"; value = String.valueOf(i+1); }
            if(suit == "Joker") game.addJoker(value);
            else game.addCard(suit, value);
            handAList.add(i);
        }
        game.addHand(handAList);

        int listBLength = 4;
        ArrayList<Integer> handBList = new ArrayList<>();
        for(int i = listALength; i < listALength+listBLength; ++i){
            if(i == listALength) { suit = "Joker"; value = "black"; }
            else { suit = "Diamond"; value = String.valueOf(i+1); }
            if(suit == "Joker") game.addJoker(value);
            else game.addCard(suit, value);
            handBList.add(i);
        }
        game.addHand(handBList);

        System.out.println(game.handString(0));
        System.out.println(game.handString(1));
        System.out.println(game.handBeats(0, 1));

    }
}
