package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    private final List<Integer> ballsPerAttempt;
    public static final int TOTAL_BALLS = 10;
    private int totalBallsKnocksDown = 0;

    public Frame(int capacity) {
        this.ballsPerAttempt = new ArrayList<>(capacity);
    }

    public void run(int ballsKnockdown) {
        if (ballsKnockdown > TOTAL_BALLS
                || (totalBallsKnocksDown + ballsKnockdown) > TOTAL_BALLS)
            throw new IllegalArgumentException();
        totalBallsKnocksDown += ballsKnockdown;
        ballsPerAttempt.add(ballsKnockdown);
    }

    public int size() {
       return ballsPerAttempt.size();
    }
}
