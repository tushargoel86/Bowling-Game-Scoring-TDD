package com.tushar.tdd.kata.game;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Game {
    int sum = 0;
    private List<Frame> frames;
    int currentFrame = 0;

    public Game() {
        frames = new ArrayList<>(10);
        frames.add(new Frame(2));
        IntStream.range(1, 10).mapToObj(i -> new Frame(2, frames.get(i - 1))).forEach(frames::add);
    }

    public void run(int ballsKnockdown) {
        Frame frame = frames.get(currentFrame);
        frame.run(ballsKnockdown);
        if (frame.isFrameCompleted()) {
            currentFrame++;
        }
    }

    public int score() {
        return frames.stream().mapToInt(Frame::sum).sum();
    }
}
