package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.*;

/**
 * @author pavelsmirnov
 */
public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;

    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }


    private void createGame(){
        drawScene();
    }

    private void drawScene(){
        drawField();
    }

    private void drawField(){
        for(int x=0; x < WIDTH; x++){
            for(int y=0; y < HEIGHT; y++){
                setCellValueEx(x, y, Color.GREY, "");
            }
        }


    }
}
