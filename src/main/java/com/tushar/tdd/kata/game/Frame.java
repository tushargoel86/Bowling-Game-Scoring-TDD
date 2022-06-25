package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;

public class Frame {
    List<Integer> ballsPerAttempt;

    public Frame(int capacity) {
        this.ballsPerAttempt = new ArrayList<>(capacity);
    }


    public void run(int ballsKnockdown) {
        ballsPerAttempt.add(ballsKnockdown);
    }

    public int size() {
       return ballsPerAttempt.size();
    }
}
