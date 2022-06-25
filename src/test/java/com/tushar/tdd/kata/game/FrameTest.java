package com.tushar.tdd.kata.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {

    @Test
    @DisplayName("If in first attempt all 10 balls are knockdown then that frame is completed")
    void testForSingleAttempt() {
        Frame frame = new Frame(2);

        frame.run(10);

        assertEquals(1, frame.size());
    }

    @Test
    @DisplayName("Should store 2 attempts when balls are not knockdown in first attempt")
    void testForTwoAttempts() {
        Frame frame = new Frame(2);

        frame.run(2);
        frame.run(5);

        assertEquals(2, frame.size());
    }
}
