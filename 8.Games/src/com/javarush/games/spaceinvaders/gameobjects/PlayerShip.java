package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

/**
 * @author pavelsmirnov
 * @version 1.0
 * дата создания 04.03.2021
 */
public class PlayerShip extends Ship {

    private Direction direction = Direction.UP;

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);

    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        if (direction != Direction.DOWN) this.direction = direction;
    }

    @Override
    public Bullet fire() {
        if (!this.isAlive) return null;
        return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
    }

    @Override
    public void kill() {
        if (!isAlive) return;
        isAlive = false;
        super.setAnimatedView(false,
                ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                ShapeMatrix.DEAD_PLAYER);
    }

    public void verifyHit(List<Bullet> bullets) {
        if (bullets.isEmpty()) return;
        if (this.isAlive) {
            bullets.forEach(bullet -> {
                if (bullet.isAlive && this.isAlive)
                    if (this.isCollision(bullet)) {
                        this.kill();
                        bullet.kill();
                    }
            });
        }
    }

    public void move() {
        if (!isAlive) return;
        if (direction == Direction.LEFT) x--;
        if (direction == Direction.RIGHT) x++;
        if (x < 0) x = 0;
        if ((x + width) > SpaceInvadersGame.WIDTH) x = SpaceInvadersGame.WIDTH - width;
    }
}
