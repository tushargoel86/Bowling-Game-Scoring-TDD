package com.tushar.tdd.kata.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FrameTest {

    private Frame frame;

    @BeforeEach
    private void setup() {
        frame = new Frame(2);
    }

    @Test
    @DisplayName("If in first attempt all 10 balls are knockdown then that frame is completed")
    void testForSingleAttempt() {
        validateFrame(10, 1);
    }

    @Test
    @DisplayName("Should store 2 attempts when balls are not knockdown in first attempt")
    void testForTwoAttempts() {
        frame.run(2);
        validateFrame(5, 2);
    }

    @Test
    @DisplayName("Total number of balls should not be greater than 10 in 2 attempts")
    void testForBallsValidation() {
        frame.run(2);
        validateFrame(9, -1);
    }

    @Test
    @DisplayName("Should show correct error message when number of balls are more")
    void testForCorrectErrorMessage() {
        frame.run(2);
        validateFrame(9, -1);
    }

    void validateFrame(int balls, int result) {
        try {
            frame.run(balls);
            assertEquals(result, frame.size());
        } catch (IllegalArgumentException e) {
            assertEquals("Total number of balls in a frame can't be greater than 10",
                    e.getMessage());
        }
    }
}
