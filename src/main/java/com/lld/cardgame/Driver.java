package com.lld.cardgame;

public class Driver {
    public static void main(String[] args){
        Game game = new Game();
        game.addCard("Spades", "Q");
        System.out.println(game.cardString(0));
        game.addCard("Hearts", "K");
        System.out.println(game.cardString(1));
        System.out.println(game.cardString(0)+" beats> "+game.cardString(1)+": "+game.cardBeats(0,1));
    }
}
