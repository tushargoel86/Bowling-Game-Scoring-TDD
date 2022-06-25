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

        assertEquals(score, 2);
    }
}
