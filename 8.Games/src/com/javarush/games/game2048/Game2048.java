package com.javarush.games.game2048;

import com.javarush.engine.cell.*;

public class Game2048 extends Game {
    private static final int SIDE = 4;
    private int[][] gameField = new int[SIDE][SIDE];
    private boolean isGameStopped = false;
    private int score = 0;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
        drawScene();
    }

    private void createGame() {
        gameField = new int[SIDE][SIDE];
        score = 0;
        setScore(score);
        createNewNumber();
        createNewNumber();
    }

    private void createNewNumber() {
        if (getMaxTileValue() >= 2048) win();
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
                    score += row[i - 1];
                    setScore(score);
                    result = true;
                }
        }
        return result;
    }

    @Override
    public void onKeyPress(Key key) {
        if (isGameStopped) {
            if (key == Key.SPACE) {
                isGameStopped = false;
                createGame();
                drawScene();
            } else {
                return;
            }
        }
        if (!canUserMove()) {
            gameOver();
            return;
        }
        switch (key) {
            case LEFT:
                moveLeft();
                drawScene();
                break;
            case RIGHT:
                moveRight();
                drawScene();
                break;
            case UP:
                moveUp();
                drawScene();
                break;
            case DOWN:
                moveDown();
                drawScene();
                break;
        }

    }

    private void moveLeft() {
        boolean addNumbers = false;
        for (int[] row : gameField) {
            boolean shiftRow = compressRow(row);
            boolean mergedRow = mergeRow(row);
            if (mergedRow) shiftRow = compressRow(row);
            if (shiftRow || mergedRow) {
                addNumbers = true;
            }
        }
        if (addNumbers) {
            createNewNumber();
        }

    }

    private void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    private void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    private void rotateClockwise() {
        int[][] ret = new int[SIDE][SIDE];
        for (int r = 0; r < SIDE; r++) {
            for (int c = 0; c < SIDE; c++) {
                ret[c][SIDE - 1 - r] = gameField[r][c];
            }
        }
        gameField = ret;
    }

    private int getMaxTileValue() {
        int maxValue = 0;
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                maxValue = Math.max(maxValue, gameField[y][x]);
            }
        }
        return maxValue;
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "You Win!!!", Color.WHITE, 75);
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "You Lose!!!", Color.WHITE, 75);
    }


    private boolean canUserMove() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (gameField[y][x] == 0) {
                    return true;
                } else if (y < SIDE - 1 && gameField[y][x] == gameField[y + 1][x]) {
                    return true;
                } else if ((x < SIDE - 1) && gameField[y][x] == gameField[y][x + 1]) {
                    return true;
                }
            }
        }
        return false;
    }
}
