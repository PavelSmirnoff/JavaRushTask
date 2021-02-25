package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.ShapeMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavelsmirnov
 */
public class EnemyFleet{
    private final static int ROWS_COUNT = 3;
    private final static int COLUMNS_COUNT = 10;
    private final static int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;

    private void createShips(){
        ships = new ArrayList<>();
    }
}
