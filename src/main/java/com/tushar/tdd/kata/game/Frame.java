package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private final List<Integer> ballsPerAttempt;
    public static final int TOTAL_BALLS = 10;
    private int totalBallsKnocksDown = 0;
    private int sum = 0;

    public Frame(int capacity) {
        this.ballsPerAttempt = new ArrayList<>(capacity);
    }

    public void run(int ballsKnockdown, Frame previousFrame) {
        if (ballsKnockdown > TOTAL_BALLS
                || (totalBallsKnocksDown + ballsKnockdown) > TOTAL_BALLS)
            throw new IllegalArgumentException("Total number of balls in a frame can't be greater than 10");
        totalBallsKnocksDown += ballsKnockdown;
        ballsPerAttempt.add(ballsKnockdown);
        sum += totalBallsKnocksDown;
        if (previousFrame != null && ballsPerAttempt.size() == 1
                && previousFrame.sum() == 10) {
            previousFrame.addBonus(ballsPerAttempt.get(0));
        }
    }

    private void addBonus(int bonus) {
        this.sum += bonus;
    }

    public int size() {
       return ballsPerAttempt.size();
    }

    public int sum() {
        if (ballsPerAttempt.size() == 0) throw new IllegalArgumentException();
        return sum;
    }
}
