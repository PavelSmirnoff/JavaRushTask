package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;

/**
 * @author pavelsmirnov
 */
public class EnemyShip extends Ship{
    public EnemyShip(double x, double y) {
        super(x, y);
        super.setStaticView(ShapeMatrix.ENEMY);
    }
}
