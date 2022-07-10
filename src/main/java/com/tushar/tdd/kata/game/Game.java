package com.tushar.tdd.kata.game;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public static final int TOTAL_INTERMEDIATE_FRAMES = 9;
    private final List<BaseFrame> frames;
    private int currentFrame = 0;

    public Game() {
        frames = new ArrayList<>();
        BaseFrame prev = getIntermediateFrames();
        FinalFrame frame = new FinalFrame();
        frame.setPreviousFrame(prev);
        frames.add(frame);
    }

    private BaseFrame getIntermediateFrames() {
        BaseFrame prev = null;
        for (int i = 0; i < TOTAL_INTERMEDIATE_FRAMES; i++) {
            BaseFrame frame = new IntermediateFrame();
            frame.setPreviousFrame(prev);
            prev = frame;
            frames.add(frame);
        }
        return prev;
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
