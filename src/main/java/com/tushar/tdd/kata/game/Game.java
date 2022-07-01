package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private final List<BaseFrame> frames;
    int currentFrame = 0;

    public Game() {
        frames = new ArrayList<>(10);
        frames.add(new IntermediateFrame(2));
        IntStream.range(1, 10).mapToObj(i -> new IntermediateFrame(2, frames.get(i - 1)))
                .forEach(frames::add);
    }

    public void run(int ballsKnockdown) {
        BaseFrame frame = frames.get(currentFrame);
        frame.run(ballsKnockdown);
        if (frame.isFrameCompleted()) {
            currentFrame++;
        }
    }

    public int score() {
        return frames.stream().mapToInt(BaseFrame::sum).sum();
    }
}
