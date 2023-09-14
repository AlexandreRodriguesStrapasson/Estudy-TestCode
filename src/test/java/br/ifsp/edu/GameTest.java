package br.ifsp.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    private Game game;

    private void rollMany(int pins) {
        for (int i = 0; i < 20; i++) {
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
        rollMany(0);

        assertThat(game.score()).isEqualTo(0);
    }
    
    @Test
    @DisplayName("Should score 40 if scores always 2")
    void shouldScore40IfScoresAlways2() {
        rollMany(2);

        assertThat(game.score()).isEqualTo(40);
    }

    @Test
    @DisplayName("Should get bonus if spare")
    void shouldGetBonusIfSpare() {
        game.roll(3);
        game.roll(7);
        game.roll(7);
        for (int i = 0; i < 17; i++) {
            game.roll(0);
        }
        assertThat(game.score()).isEqualTo(24);

    }


}