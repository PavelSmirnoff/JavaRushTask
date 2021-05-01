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

    @Override
    public Bullet fire() {
        return new Bullet(x + 1, y + height, Direction.DOWN);
    }

    @Override
    public void kill() {
        if(!isAlive) return;
        isAlive = false;
        super.setAnimatedView(ShapeMatrix.KILL_ENEMY_ANIMATION_FIRST,
                ShapeMatrix.KILL_ENEMY_ANIMATION_SECOND,
                ShapeMatrix.KILL_ENEMY_ANIMATION_THIRD);
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
