package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavelsmirnov
 */
public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    private List<Star> stars;
    private EnemyFleet enemyFleet;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }


    private void createGame() {
        setTurnTimer(40);
        createStars();
        enemyFleet = new EnemyFleet();
        drawScene();
    }

    private void drawScene() {
        drawField();
        enemyFleet.draw(this);
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.GREY, "");
            }
        }
        for(Star star: stars){
            star.draw(this);
        }
    }

    private void createStars(){
        stars = new ArrayList<>();
        for(int i=0; i<8; i++){
            stars.add(new Star(getRandomNumber(WIDTH),getRandomNumber(HEIGHT)));
        }
    }

    @Override
    public void onTurn(int step) {
        drawScene();
    }
}
