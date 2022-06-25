package com.tushar.tdd.kata.game;

public class Game {
    int sum = 0;

    public void run(int ballsKnockdown) {
        this.sum = ballsKnockdown;
    }

    public int score() {
        return sum;
    }
}
