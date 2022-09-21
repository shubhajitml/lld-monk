package com.lld.snakeLadder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int minValue = 1, maxValue = 6;

    public Dice(int diceCount){
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int totalDiceRollsSum = 0;
        int diceUsed = 0;
        while(diceUsed < diceCount){
            totalDiceRollsSum += ThreadLocalRandom.current().nextInt(minValue, maxValue+1);
            diceUsed++;
        }
        return totalDiceRollsSum;
    }
}
