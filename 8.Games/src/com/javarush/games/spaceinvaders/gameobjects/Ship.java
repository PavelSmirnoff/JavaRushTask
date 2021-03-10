package com.javarush.games.spaceinvaders.gameobjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author pavelsmirnov
 */
public class Ship extends GameObject{
    private List<int[][]> frames;
    private int frameIndex;
    public boolean isAlive = true;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame){
        super.setMatrix(viewFrame);
        frames = new ArrayList<int[][]>();
        frames.add(viewFrame);
        frameIndex = 0;
    }

    public Bullet fire(){
        return null;
    }

    public void kill(){
        isAlive = false;
    }

    public void setAnimatedView(int[][]... viewFrames){
        setMatrix(viewFrames[0]);
        frames = Arrays.asList(viewFrames);
        frameIndex = 0;

    }
}
