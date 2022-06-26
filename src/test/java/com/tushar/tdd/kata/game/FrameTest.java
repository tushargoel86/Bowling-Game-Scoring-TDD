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
        frame.run(2, null);
        validateFrame(5, 2);
    }

    @Test
    @DisplayName("Total number of balls should not be greater than 10 in 2 attempts")
    void testForBallsValidation() {
        frame.run(2, null);
        validateFrame(9, -1);
    }

    @Test
    @DisplayName("Should show correct error message when number of balls are more")
    void testForCorrectErrorMessage() {
        frame.run(2, null);
        validateFrame(9, -1);
    }

    void validateFrame(int balls, int result) {
        try {
            frame.run(balls, frame);
            assertEquals(result, frame.size());
        } catch (IllegalArgumentException e) {
            assertEquals("Total number of balls in a frame can't be greater than 10",
                    e.getMessage());
        }
    }

    @Test
    @DisplayName("Should show sum equals to 2 when 2 balls knockdown")
    void shouldHaveFrameSumEqualsToBallsKnockDown() {
       validateSum(2, 8, 10);
    }

    @Test
    @DisplayName("Should show sum equals to 6 when 6 balls knockdown")
    void shouldHaveFrameCountEqualsToBallsKnockDown() {
      validateSum(1, 5, 6);
    }

    @Test
    @DisplayName("Should throw exception in case still frame is not reached")
    void testForFrameSumForValidOne() {
       assertThrows(IllegalArgumentException.class, () -> frame.sum());
    }

    @Test
    @DisplayName("Should show sum equals to 16 when strike is hit and next attempt has 6 balls")
    void testForStrike() {
        frame.run(6, frame);
        frame.run(4, frame);

        Frame frame2 = new Frame(2);
        frame2.run(6, frame);

        assertEquals(16, frame.sum());
    }

    void validateSum(int ball1, int ball2, int result) {
        frame.run(ball1, null);
        frame.run(ball2, null);

        assertEquals(ball1 + ball2, result);
    }
}
