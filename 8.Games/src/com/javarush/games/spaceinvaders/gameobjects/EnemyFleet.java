package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.ShapeMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavelsmirnov
 */
public class EnemyFleet {
    private final static int ROWS_COUNT = 3;
    private final static int COLUMNS_COUNT = 10;
    private final static int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;

    public EnemyFleet() {
        createShips();
    }

    private void createShips() {
        ships = new ArrayList<>();
        for (int x = 0; x < COLUMNS_COUNT; x++) {
            for (int y = 0; y < ROWS_COUNT; y++) {
                ships.add(new EnemyShip(x * STEP,y * STEP + 12));
            }
        }
    }

    public void draw(Game game){
        for (EnemyShip eShip: ships) {
            eShip.draw(game);
        }
    }
}
