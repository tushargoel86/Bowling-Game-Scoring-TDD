package com.tushar.tdd.kata.game;

public class IntermediateFrame extends BaseFrame {
    public IntermediateFrame() {
       super(2);
    }

    public void validateMove(int ballsKnockdown) {
        if (ballsKnockdown > TOTAL_BALLS
                || (totalBallsKnockDown() + ballsKnockdown) > TOTAL_BALLS)
            throw new IllegalArgumentException("Total number of balls in a frame " +
                    "can't be greater than 10");
    }

}
