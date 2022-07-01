package com.tushar.tdd.kata.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    private Game game;

    @BeforeEach
    void setup() {
        this.game = new Game();
    }

    @Test
    @DisplayName("Should show correct sum for strike")
    void testForStrike() {
        testForValidScore(27, 2,8, 8, 1);
    }


    @Test
    @DisplayName("Should sum the previous sum with the frame sum")
    void testForFrameWithPreviousSum() {
        testForValidScore(13, 4, 4, 5);
    }

    @Test
    @DisplayName("Should sum for the spare")
    void testForSpare() {
        testForValidScore(28, 10, 4, 5);
    }

    void testForValidScore(int target, int... attempts) {
        for (int attempt : attempts) {
            game.run(attempt);
        }
        int score = game.score();
        assertEquals(target, score);
    }
}
