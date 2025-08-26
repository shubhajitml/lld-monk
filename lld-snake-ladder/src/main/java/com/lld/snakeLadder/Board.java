package com.lld.snakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Board {
    Cell[][] cells;

    Board(int boardSize, int numberOfSnakes, int numberOfLadders){
        initializeCells(boardSize);
        addSnakeAndLadders(cells, numberOfSnakes, numberOfLadders);
    }

    private void initializeCells(int boardSize){
        cells = new Cell[boardSize][boardSize];
        for(int i = 0; i < boardSize; ++i){
            for(int j = 0; j < boardSize; ++j){
                cells[i][j] = new Cell();
            }
        }
    }

    private void addSnakeAndLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        for(int i = 0; i < numberOfSnakes; ++i) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, (cells.length * cells.length)-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, (cells.length * cells.length)-1);
            if (snakeTail >= snakeHead) continue;

            Jump snakeObject = new Jump();
            snakeObject.start = snakeHead;
            snakeObject.end = snakeTail;

            Cell cell = getCellFromBoardPosition(snakeHead);
            cell.jump = snakeObject;
        }

        for(int i = 0; i < numberOfLadders; ++i) {
            int ladderStart = ThreadLocalRandom.current().nextInt(1, (cells.length * cells.length) - 1);
            int ladderEnd = ThreadLocalRandom.current().nextInt(1, (cells.length * cells.length) - 1);
            if (ladderStart >= ladderEnd) continue;

            Jump snakeObject = new Jump();
            snakeObject.start = ladderStart;
            snakeObject.end = ladderEnd;

            Cell cell = getCellFromBoardPosition(ladderStart);
            cell.jump = snakeObject;
        }

    }

    public Cell getCellFromBoardPosition(int position){
        int boardRow = position / cells.length;
        int boardColumn = position % cells.length;
        return cells[boardRow][boardColumn];
    }

}
