package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavelsmirnov
 */
public class Ship extends GameObject {
    private List<int[][]> frames;
    private int frameIndex;
    private boolean loopAnimation = false;
    public boolean isAlive = true;


    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame) {
        super.setMatrix(viewFrame);
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public Bullet fire() {
        return null;
    }

    public void kill() {
        isAlive = false;
    }

    //    public void setAnimatedView(int[][]... viewFrames){
//        setMatrix(viewFrames[0]);
//        frames = Arrays.asList(viewFrames);
//        frameIndex = 0;
//
//    }
    public void setAnimatedView(boolean isLoopAnimation, int[][]... viewFrames) {
        loopAnimation = isLoopAnimation;
    }

    public void nextFrame() {
        frameIndex++;

        if (frameIndex >= frames.size()) {
            if (loopAnimation) {
                frameIndex = 0;
            } else {
                return;
            }
        }
        matrix = frames.get(frameIndex);
    }

    @Override
    public void draw(Game game) {
        super.draw(game);
        nextFrame();
    }

    public boolean isVisible() {
        if (!isAlive && frameIndex >= frames.size()) return false;
        return true;
    }
}
