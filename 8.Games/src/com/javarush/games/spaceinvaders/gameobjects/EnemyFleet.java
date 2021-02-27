package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.Direction;
import com.javarush.games.spaceinvaders.ShapeMatrix;
import com.javarush.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.DoubleStream;

/**
 * @author pavelsmirnov
 */
public class EnemyFleet {
    private final static int ROWS_COUNT = 3;
    private final static int COLUMNS_COUNT = 10;
    private Direction direction = Direction.RIGHT;
    private final static int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP, y * STEP + 12));
            }
        }
    }

    public void draw(Game game) {
        for (EnemyShip eShip : ships) {
            eShip.draw(game);
        }
    }

    private double getLeftBorder() {
        return ships.stream().flatMapToDouble(num -> DoubleStream.of(num.x)).min().getAsDouble();
    }

    private double getRightBorder() {
        return ships.stream().flatMapToDouble(num -> DoubleStream.of(num.x + num.width)).max().getAsDouble();
    }

    private double getSpeed() {
        int count = ships.size();
        double speed = 3.0 / count;
        return Math.min(speed, 2.0);
    }

    public void move() {
        boolean directionChange = false;
        if (ships.isEmpty()) return;
        if (direction.equals(Direction.LEFT) && getLeftBorder() < 0) {
            direction = Direction.RIGHT;
            directionChange = true;
        }
        if (direction.equals(Direction.RIGHT) && getRightBorder() > SpaceInvadersGame.WIDTH) {
            direction = Direction.LEFT;
            directionChange = true;
        }
        double speed = getSpeed();
        for (EnemyShip e: ships) {
            e.move((directionChange)?Direction.DOWN:direction,speed);
        }
    }
}
