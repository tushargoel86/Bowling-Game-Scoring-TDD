package com.tushar.tdd.kata.game;

public class FinalFrame extends BaseFrame {

    public static final int MAX_ATTEMPTS = 3;
    public static final int FIRST_ATTEMPT = 0;
    public static final int SECOND_ATTEMPT = 2;

    public FinalFrame() {
        super(3);
    }

    @Override
    protected void updateBonusOfPreviousFrame(int balls) {
        if (numberOfAttempts() > MAX_ATTEMPTS)
            throw new IllegalArgumentException("More than 3 attempts are not allowed");
        super.updateBonusOfPreviousFrame(balls);
        if (isFrameCompleted() && (isStrike() || isSpare())) {
            addBonus(balls - getBallsPerAttempt().get(FIRST_ATTEMPT));
        }
    }

    @Override
    protected void validateMove(int ballsKnockdown) {
        if (totalBallsKnockDown() < TOTAL_BALLS
                && numberOfAttempts() == SECOND_ATTEMPT)
            throw new IllegalArgumentException("3rd attempt is not allowed without Strike/Spare");
    }

    @Override
    public boolean isFrameCompleted() {
        return (totalBallsKnockDown() < TOTAL_BALLS
                    && numberOfAttempts() == SECOND_ATTEMPT)
                || numberOfAttempts() == 3;
    }
}
