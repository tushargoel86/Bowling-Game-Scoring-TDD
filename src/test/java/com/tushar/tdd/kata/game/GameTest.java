package com.tushar.tdd.kata.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    @DisplayName("Should show correct sum for strike")
    void testForStrike() {
        Game game = new Game();
        game.run(2);
        game.run(8);
        game.run(8);
        game.run(1);

        int score = game.score();

        assertEquals(27, score);
    }


    @Test
    @DisplayName("Should sum the previous sum with the frame sum")
    void testForFrameWithPreviousSum() {
        Game game = new Game();
        game.run(4);
        game.run(4);
        game.run(5);

        int score = game.score();

        assertEquals(13, score);
    }

    @Test
    @DisplayName("Should sum for the spare")
    void testForSpare() {
        Game game = new Game();
        game.run(10);
        game.run(4);
        game.run(5);

        int score = game.score();

        assertEquals(28, score);
    }
}
