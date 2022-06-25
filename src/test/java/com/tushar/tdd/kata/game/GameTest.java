package com.tushar.tdd.kata.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {

    @Test
    @DisplayName("Should have sum equals to number of balls knockdown")
    void testForSumEqualsToBallsKnockdown() {
        Game game = new Game();
        game.run(2);

        int score = game.score();

        assertEquals(2, score);
    }

    @Test
    @DisplayName("Should have sum equals to 10, when 8 balls are knockdonw in 2nd attmept and" +
            " 2 in first attempt")
    void testForSumEqualsToPreviousAttemptAndCurrentAttempt() {
        Game game = new Game();
        game.run(2);
        game.run(8);

        int score = game.score();

        assertEquals(10, score);
    }


}
