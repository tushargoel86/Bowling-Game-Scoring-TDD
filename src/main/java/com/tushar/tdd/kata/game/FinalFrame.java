package com.tushar.tdd.kata.game;

public class FinalFrame extends BaseFrame {
    public FinalFrame() {
        super(3);
    }

    @Override
    protected void updateBonusOfPreviousFrame(int balls) {
        if (numberOfAttempts() > 3)
            throw new IllegalArgumentException("More than 3 attempts are not allowed");
        super.updateBonusOfPreviousFrame(balls);
        if (isStrike() || isSpare()) {
            addBonus(balls);
        }
    }

    @Override
    protected void validateMove(int ballsKnockdown) {
        if (numberOfAttempts() > 3)
            throw new IllegalArgumentException("More than 3 attempts not allowed");
    }
}
