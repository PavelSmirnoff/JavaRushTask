package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;

/**
 * This write description created class
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 01.05.2021
 */
public class Boss extends EnemyShip{

    private int frameCount = 0;

    public Boss(double x, double y) {
        super(x, y);
        super.setAnimatedView(ShapeMatrix.BOSS_ANIMATION_FIRST, ShapeMatrix.BOSS_ANIMATION_SECOND);
    }

    @Override
    public void nextFrame() {
        frameCount++;
        if(!isAlive||frameCount%10==0) super.nextFrame();
    }
}
