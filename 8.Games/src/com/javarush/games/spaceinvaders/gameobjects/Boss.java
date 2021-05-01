package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

/**
 * This write description created class
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 01.05.2021
 */
public class Boss extends EnemyShip {

    private int frameCount = 0;

    public Boss(double x, double y) {
        super(x, y);
        super.setAnimatedView(ShapeMatrix.BOSS_ANIMATION_FIRST, ShapeMatrix.BOSS_ANIMATION_SECOND);
    }

    @Override
    public Bullet fire() {
        if (!isAlive) return null;
        return (matrix == ShapeMatrix.BOSS_ANIMATION_FIRST) ?
                new Bullet(x + 6, y + height, Direction.DOWN) :
                new Bullet(x, y + height, Direction.DOWN);
    }

    @Override
    public void nextFrame() {
        frameCount++;
        if (!isAlive || frameCount % 10 == 0) super.nextFrame();
    }

    @Override
    public void kill() {
        isAlive = false;
        super.setAnimatedView(ShapeMatrix.KILL_BOSS_ANIMATION_FIRST,
                ShapeMatrix.KILL_BOSS_ANIMATION_SECOND,
                ShapeMatrix.KILL_BOSS_ANIMATION_THIRD);
    }
}
