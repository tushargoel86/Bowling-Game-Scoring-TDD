package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    public static final int FIRST_ATTEMPT = 1;
    public static final int SECOND_ATTEMPT = 2;
    private final List<Integer> ballsPerAttempt;
    public static final int TOTAL_BALLS = 10;
    private int totalBallsKnocksDown = 0;
    private int sum = 0;
    private Frame previousFrame;

    public Frame(int capacity) {
        this.ballsPerAttempt = new ArrayList<>(capacity);
    }

    public Frame(int capacity, Frame previousFrame) {
        this.ballsPerAttempt = new ArrayList<>(capacity);
        this.previousFrame = previousFrame;
    }

    public void run(int ballsKnockdown) {
        validateMove(ballsKnockdown);
        totalBallsKnocksDown += ballsKnockdown;
        ballsPerAttempt.add(ballsKnockdown);
        sum += ballsKnockdown;
        updateBonusOfPreviousFrame(ballsKnockdown);
    }

    private void validateMove(int ballsKnockdown) {
        if (ballsKnockdown > TOTAL_BALLS
                || (totalBallsKnocksDown + ballsKnockdown) > TOTAL_BALLS)
            throw new IllegalArgumentException("Total number of balls in a frame can't be greater than 10");
    }

    private void updateBonusOfPreviousFrame(int balls) {
        if (previousFrame == null) return;
        if (previousFrame.getType().equals(FrameType.STRIKE)) {
            previousFrame.addBonus(balls);
        } else if (previousFrame.getType().equals(FrameType.SPARE)) {
            previousFrame.addBonus(balls);
        }
    }

    private void addBonus(int bonus) {
        this.sum += bonus;
    }

    public int size() {
       return ballsPerAttempt.size();
    }

    public int sum() {
        return sum;
    }

    private FrameType getType() {
        if (totalBallsKnocksDown != 10) return FrameType.NONE;
        if (ballsPerAttempt.size() == 2) {
            return FrameType.STRIKE;
        } else {
            return FrameType.SPARE;
        }

    }
}
