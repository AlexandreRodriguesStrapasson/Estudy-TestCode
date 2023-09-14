package br.ifsp.edu;

public class Game {
    private int score;
    private int[] rolls = new int[21];
    private int numberOfRolls;

    public void roll(int pins) {
        rolls[numberOfRolls++] = pins;
    }

    public int score() {
        int rollIndex = 0;

        for (int i = 0; i < 10; i++) {
            if(rolls[rollIndex] + rolls[rollIndex + 1] == 10){
                score = 10 + rolls[rollIndex + 2];
            }else{
                score += rolls[rollIndex] + rolls[rollIndex + 1];
            }
            rollIndex += 2;

        }
        return score;
    }
}
