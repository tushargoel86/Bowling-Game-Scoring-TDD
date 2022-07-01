package com.tushar.tdd.kata.game;

public class IntermediateFrame extends BaseFrame {
    public IntermediateFrame(int capacity) {
       super(capacity);
    }

    public IntermediateFrame(int capacity, BaseFrame previousFrame) {
       super(capacity, previousFrame);
    }

    public void validateMove(int ballsKnockdown) {
        if (ballsKnockdown > TOTAL_BALLS
                || (totalBallsKnockDown() + ballsKnockdown) > TOTAL_BALLS)
            throw new IllegalArgumentException("Total number of balls in a frame " +
                    "can't be greater than 10");
    }

}
