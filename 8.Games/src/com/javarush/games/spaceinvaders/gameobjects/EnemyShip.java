package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;

/**
 * @author pavelsmirnov
 */
public class EnemyShip extends Ship{
    public EnemyShip(double x, double y) {
        super(x, y);
        super.setStaticView(ShapeMatrix.ENEMY);
    }

    public void move(Direction direction, double speed){
        if(direction.equals(Direction.RIGHT)){
            x += speed;
        }
        if(direction.equals(Direction.LEFT)){
            x -= speed;
        }
        if(direction.equals(Direction.DOWN)){
            y += 2;
        }
    }
}
