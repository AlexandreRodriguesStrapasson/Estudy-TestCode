package br.ifsp.edu;

public class Game {
    final private int[] rolls = new int[21];
    private int numberOfRolls;

    public void roll(int pins) {
        rolls[numberOfRolls++] = pins;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;

        for (int i = 0; i < 10; i++) {
            if(IsStrike(rolls[rollIndex])){
                score += 10 + strikeBonus(rollIndex);
                rollIndex ++;
            } else if(isSpare(rolls[rollIndex] + rolls[rollIndex + 1])){
                score = 10 + spareBonus(rollIndex);
                rollIndex += 2;
            }else{
                score += frameScore(rollIndex);
                rollIndex += 2;
            }


        }
        return score;
    }


    private boolean IsStrike(int rolls) {
        return isSpare(rolls);
    }

    private int strikeBonus(int rollIndex){
        return rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private boolean isSpare(int rolls) {
        return rolls == 10;
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private int frameScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }




}
