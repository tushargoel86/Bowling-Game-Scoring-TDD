package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseFrame {
    public static final int FIRST_ATTEMPT = 1;
    public static final int SECOND_ATTEMPT = 2;
    private final List<Integer> ballsPerAttempt;
    public static final int TOTAL_BALLS = 10;
    private int totalBallsKnocksDown = 0;
    private int sum = 0;
    private BaseFrame previousFrame;

    public BaseFrame(int capacity) {
        this.ballsPerAttempt = new ArrayList<>(capacity);
    }

    protected void addBonus(int bonus) {
        this.sum += bonus;
    }

    public int size() {
        return ballsPerAttempt.size();
    }

    public int sum() {
        return sum;
    }

    public boolean isSpare() {
        return totalBallsKnocksDown == TOTAL_BALLS && ballsPerAttempt.size() == FIRST_ATTEMPT;
    }

    public boolean isStrike() {
        return totalBallsKnocksDown == TOTAL_BALLS && ballsPerAttempt.size() == SECOND_ATTEMPT;
    }

    public boolean isFrameCompleted() {
        return totalBallsKnocksDown == TOTAL_BALLS || ballsPerAttempt.size() == 2;
    }

    protected int numberOfAttempts() {
        return ballsPerAttempt.size();
    }

    protected void addBallsKnockdown(int ballsKnockdown) {
        ballsPerAttempt.add(ballsKnockdown);
    }

    public List<Integer> getBallsPerAttempt() {
        return ballsPerAttempt;
    }

    protected abstract void validateMove(int ballsKnockdown);

    protected void updateBonusOfPreviousFrame(int balls) {
        if (previousFrame == null) return;
        if (numberOfAttempts() == FIRST_ATTEMPT && previousFrame.isStrike()) {
            previousFrame.addBonus(balls);
        } else if (numberOfAttempts() == SECOND_ATTEMPT && previousFrame.isSpare()) {
            previousFrame.addBonus(balls);
        } else if (numberOfAttempts() == FIRST_ATTEMPT && previousFrame.isSpare()
                && totalBallsKnocksDown == TOTAL_BALLS) {
            previousFrame.addBonus(balls);
        }
    }

    public void run(int ballsKnockdown) {
        validateMove(ballsKnockdown);
        addBallsKnockdown(ballsKnockdown);
        totalBallsKnocksDown += ballsKnockdown;
        sum += ballsKnockdown;
        updateBonusOfPreviousFrame(totalBallsKnocksDown);
    }

    protected int totalBallsKnockDown() {
        return totalBallsKnocksDown;
    }

    public void setPreviousFrame(BaseFrame frame) {
        this.previousFrame = frame;
    }
}
