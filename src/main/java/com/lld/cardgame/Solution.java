package com.lld.cardgame;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        String[] segments = scanner.nextLine().split(" ");
        game.addCard(segments[0], segments[1]);
        System.out.println(game.cardString(0));
        segments = scanner.nextLine().split(" ");
        game.addCard(segments[0], segments[1]);
        System.out.println(game.cardString(1));
        System.out.println(game.cardBeats(0,1));
        scanner.close();
    }
}
