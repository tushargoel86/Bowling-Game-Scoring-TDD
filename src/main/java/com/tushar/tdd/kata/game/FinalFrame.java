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
        if (isFrameCompleted() && (isStrike() || isSpare())) {
            addBonus(balls - getBallsPerAttempt().get(0));
        }
    }

    @Override
    protected void validateMove(int ballsKnockdown) {
        if (totalBallsKnockDown() < TOTAL_BALLS && numberOfAttempts() == 2)
            throw new IllegalArgumentException("3rd attempt is not allowed without Strike/Spare");
    }

    @Override
    public boolean isFrameCompleted() {
        return (totalBallsKnockDown() < TOTAL_BALLS && numberOfAttempts() == 2)
                || numberOfAttempts() == 3;
    }
}
