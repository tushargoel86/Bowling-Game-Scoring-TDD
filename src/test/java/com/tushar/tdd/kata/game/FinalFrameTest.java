package com.tushar.tdd.kata.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FinalFrameTest {

    FinalFrame frame;

    @BeforeEach
    void setup() {
        this.frame = new FinalFrame();
    }

    @Test
    void showThreeAttemptsWhenSpareOrStrike() {
        assertingForEqualValue(3, () -> frame.numberOfAttempts(), 3, 7, 4);
    }

    @Test
    @DisplayName("Should return sum of three attempts in case of strike or spare")
    void testSumWhenSpareHit() {
       assertingForEqualValue(20, () -> frame.sum(), 10, 7, 3);
       assertingForEqualValue(16, () -> frame.sum(), 3, 7, 3);
    }

    @Test
    @DisplayName("Should throw exception when more than three attempts")
    void testForInvalidAttempt() {
        assertingForEqualValue(1, () -> frame.sum(), 10, 7, 3, 3);
    }

    private void assertingForEqualValue(int result, Supplier<Integer> supplier, int... inputs) {
        try {
            for(int inp : inputs) {
                frame.run(inp);
            }
            assertEquals(result, supplier.get());
        } catch (Exception e) {
            assertEquals("More than 3 attempts are not allowed", e.getMessage());
        }
    }

    @Test
    @DisplayName("Should not allow third attempt when not strike and spare")
    void testForInvalidAttemptWhenNotStrikeOrSpare() {
        FinalFrame frame = new FinalFrame();
        frame.run(2);
        frame.run(7);

        assertThrows(IllegalArgumentException.class, () ->  frame.run(3));
    }
}
