package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        createNewNumber();
        createNewNumber();
    }

    private void createNewNumber() {
        int rndX = getRandomNumber(SIDE);
        int rndY = getRandomNumber(SIDE);
        while (gameField[rndX][rndY] != 0) {
            rndX = getRandomNumber(SIDE);
            rndY = getRandomNumber(SIDE);
        }
        gameField[rndX][rndY] = (getRandomNumber(10) > 8) ? 4 : 2;
    }

    private void setCellColoredNumber(int x, int y, int value) {
        setCellValueEx(x, y, getColorByValue(value), (value == 0) ? "" : String.valueOf(value));
    }

    private Color getColorByValue(int value) {
        switch (value) {
            case 0:
                return Color.WHITE;
            case 2:
                return Color.PLUM;
            case 4:
                return Color.SLATEBLUE;
            case 8:
                return Color.DODGERBLUE;
            case 16:
                return Color.DARKTURQUOISE;
            case 32:
                return Color.MEDIUMSEAGREEN;
            case 64:
                return Color.LIMEGREEN;
            case 128:
                return Color.DARKORANGE;
            case 256:
                return Color.SALMON;
            case 512:
                return Color.ORANGERED;
            case 1024:
                return Color.DEEPPINK;
            case 2048:
                return Color.MEDIUMVIOLETRED;
            default:
                return Color.NONE;
        }
    }

    private void drawScene() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                setCellColoredNumber(x, y, gameField[y][x]);
            }
        }
    }

    private boolean compressRow(int[] row) {
        int shift = 0;
        boolean result = false;
        for (int i = 0; i < SIDE; i++) {
            if (row[i] != 0) {
                if (i != shift) {
                    row[shift] = row[i];
                    row[i] = 0;
                    result = true;
                }
                shift++;
            }
        }
        return result;
    }

    private boolean mergeRow(int[] row) {
        boolean result = false;
        for (int i = 1; i < SIDE; i++) {
            if (row[i - 1] > 0)
                if ((row[i - 1] == row[i])) {
                    row[i - 1] += row[i];
                    row[i] = 0;
                    result = true;
                }
        }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case LEFT:
                moveLeft();
                break;
            case RIGHT:
                moveRight();
                break;
            case UP:
                moveUp();
                break;
            case DOWN:
                moveDown();
                break;
        }
    }

    private void moveLeft() {

    }

    private void moveRight() {

    }

    private void moveUp() {

    }

    private void moveDown() {

    }
}
