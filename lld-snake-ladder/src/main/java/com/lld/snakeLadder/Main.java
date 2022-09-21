package com.lld.snakeLadder;

public class Main {
    public static void main( String[] args ) {
        int boardSize = 10;
        int noOfSnakes = 11;
        int noOfLadders = 4;
        Game game = new Game(boardSize, noOfSnakes, noOfLadders);
        game.startGame();
    }
}
