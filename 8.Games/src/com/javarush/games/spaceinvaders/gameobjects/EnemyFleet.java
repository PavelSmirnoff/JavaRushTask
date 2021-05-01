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
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1, 5));
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
        for (EnemyShip e : ships) {
            e.move((directionChange) ? Direction.DOWN : direction, speed);
        }
    }

    public Bullet fire(Game game) {
        if (ships.isEmpty()) return null;
        int rnd = game.getRandomNumber(100 / SpaceInvadersGame.COMPLEXITY);
        if (rnd > 0) return null;

        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    public void verifyHit(List<Bullet> bullets){
        for (Ship ship :ships) {
            for (Bullet bullet : bullets) {
                if(ship.isCollision(bullet)&&ship.isAlive&&bullet.isAlive){
                    ship.kill();
                    bullet.kill();
                }
            }
        }
    }

    public void deleteHiddenShips(){
        ships.removeIf(x -> !x.isVisible());
    }

    public double getBottomBorder(){
        if(ships.size()==0) return 0.0;
        return ships.stream().flatMapToDouble(s -> DoubleStream.of(s.y + s.height)).max().getAsDouble();
    }

    public int getShipsCount(){
        return ships.size();
    }
}
