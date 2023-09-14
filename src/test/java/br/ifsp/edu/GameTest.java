package br.ifsp.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    private Game game;

    private void rollMany(int numberOfRolls, int pins) {
        for (int i = 0; i < numberOfRolls; i++) {
            game.roll(pins);
        }
    }
    
    @BeforeEach
    void setUp(){
        game = new Game();
    }
    
    

    @Test
    @DisplayName("Should score zero in gutter game")
    void shouldScoreZeroInGutterGame() {
        rollMany(20, 0);

        assertThat(game.score()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("Should score 40 if scores always 2")
    void shouldScore40IfScoresAlways2() {
        rollMany(20, 2);

        assertThat(game.score()).isEqualTo(40);
    }

    @Test
    @DisplayName("Should get bonus if spare")
    void shouldGetBonusIfSpare() {
        rollSpare(3, 7);
        game.roll(7);
        rollMany(17, 0);
        assertThat(game.score()).isEqualTo(24);
    }

    @Test
    @DisplayName("Should get bonus if strikes")
    void shouldGetBonusIfStrikes() {
        rollStrike(10);
        game.roll(5);
        game.roll(3);
        rollMany(16, 0);

        assertThat(game.score()).isEqualTo(26);
    }

    @Test
    @DisplayName("Should get 300 if strike all frames")
    void shouldGet300IfStrikeAllFrames() {
        rollMany(12, 10);
        assertThat(game.score()).isEqualTo(300);
    }


    private void rollSpare(int pins, int pins1) {
        game.roll(pins);
        game.roll(pins1);
    }

    private void rollStrike(int pins) {
        game.roll(pins);
    }


}