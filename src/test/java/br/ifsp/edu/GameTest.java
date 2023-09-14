package br.ifsp.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class GameTest {
    @BeforeEach
    void setUp(){

    }

    @Test
    @DisplayName("Should score zero in gutter game")
    void shouldScoreZeroInGutterGame() {
        Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }

        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    @DisplayName("Should score 40 if scores always 2")
    void shouldScore40IfScoresAlways2() {
         Game game = new Game();
        for (int i = 0; i < 20; i++) {
            game.roll(2);
        }

        assertThat(game.score()).isEqualTo(40);
    }


}