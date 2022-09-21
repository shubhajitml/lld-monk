package com.lld.snakeLadder;

import java.util.Deque;
import java.util.LinkedList;

public class Game {
    Board board;
    Dice dice;
    Deque<Player> playersList = new LinkedList<>();
    Player winner;

    public Game(){
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    public Game(int boardSize, int numberOfSnakes, int numberOfLadders){
        board = new Board(boardSize, numberOfSnakes, numberOfLadders);
        dice = new Dice(1);
        winner = null;
        addPlayers();
    }

    private void addPlayers(){
        Player player1 = new Player("p1", 0);
        Player player2 = new Player("p2", 0);
        playersList.add(player1);
        playersList.add(player2);

    }

    public void startGame(){
        while (winner == null) {
            //1. Check whose turn now
            Player currentPlayer = findPlayerTurn();
            System.out.println("Player turn is: " + currentPlayer.id + ", current position is: "
                    + currentPlayer.currentPosition);

            //2. Roll the dice
            int diceValueAfterRolls = dice.rollDice();
            System.out.println("dice roll value: " + diceValueAfterRolls);

            //3. Get the new position
            checkForJumpAndRepositionPlayer(currentPlayer, diceValueAfterRolls);
            System.out.println("Player ( " + currentPlayer.id + " )'s new position is: "
                    + currentPlayer.currentPosition);

            //4. Check for winning condition
            if (currentPlayer.currentPosition == (board.cells.length * board.cells.length) - 1) {
                winner = currentPlayer;
            }
        }
        System.out.println("WINNER IS: " + winner.id);
    }

    private void checkForJumpAndRepositionPlayer(Player currentPlayer, int diceRollValue) {
        int playerNewPosition = currentPlayer.currentPosition + diceRollValue;
        if(playerNewPosition > (board.cells.length * board.cells.length) - 1){
            playerNewPosition -= diceRollValue;
        }
        Cell cell = board.getCellFromBoardPosition(playerNewPosition);
        if(cell.jump != null && cell.jump.start == playerNewPosition){
            String jumpType = (cell.jump.start > cell.jump.end) ? "Snake" : "Ladder";
            System.out.println("=========================== Jump done by: " + jumpType + " ===========================");
            playerNewPosition = cell.jump.end;
        }
        currentPlayer.currentPosition = playerNewPosition;
    }

    private Player findPlayerTurn(){
        Player currentTurnPlayer = playersList.removeFirst();
        playersList.addLast(currentTurnPlayer);
        return currentTurnPlayer;
    }
}
