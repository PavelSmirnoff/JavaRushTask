package com.javarush.games.game2048;
import com.javarush.engine.cell.*;

public class Game2048 extends Game{
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize(){
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame(){
        createNewNumber();
        createNewNumber();
    }
    private void createNewNumber(){
        int rndX = getRandomNumber(SIDE);
        int rndY = getRandomNumber(SIDE);
        while (gameField[rndX][rndY]!=0){
            rndX = getRandomNumber(SIDE);
            rndY = getRandomNumber(SIDE);
        }
        gameField[rndX][rndY] = (getRandomNumber(10)>8)?4:2;
    }

    private void drawScene(){
        for(int x=0; x<SIDE;x++)
            for(int y=0; y<SIDE;y++)
                setCellColor(x, y, Color.BURLYWOOD);
    }
}
