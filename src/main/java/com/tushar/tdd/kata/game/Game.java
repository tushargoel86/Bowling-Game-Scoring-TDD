package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<BaseFrame> frames;
    int currentFrame = 0;

    public Game() {
        frames = new ArrayList<>();
        BaseFrame prev = null;
        for (int i = 0; i < 9; i++) {
            BaseFrame frame = new IntermediateFrame();
            frame.setPreviousFrame(prev);
            prev = frame;
            frames.add(frame);
        }
        FinalFrame frame = new FinalFrame();
        frame.setPreviousFrame(prev);
        frames.add(frame);
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
