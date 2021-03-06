package com.javarush.games.minesweeper;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;
    private int countFlags;
    private boolean isGameStopped;
    private int countClosedTiles = SIDE*SIDE;
    private int score;

    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
        if (isGameStopped){
            restart();
            return;
        }
        openTile(x, y);
    }

    @Override
    public void onMouseRightClick(int x, int y) {
        markTile(x, y);
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                boolean isMine = getRandomNumber(10) < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                setCellValue(y, x, "");
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
        score = 0;
    }

    private List<GameObject> getNeighbors(GameObject gameObject) {
        List<GameObject> result = new ArrayList<>();
        for (int y = gameObject.y - 1; y <= gameObject.y + 1; y++) {
            for (int x = gameObject.x - 1; x <= gameObject.x + 1; x++) {
                if (y < 0 || y >= SIDE) {
                    continue;
                }
                if (x < 0 || x >= SIDE) {
                    continue;
                }
                if (gameField[y][x] == gameObject) {
                    continue;
                }
                result.add(gameField[y][x]);
            }
        }
        return result;
    }

    private void countMineNeighbors() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                if (!gameField[y][x].isMine) {
                    List<GameObject> countMineNeighbors = getNeighbors(gameField[y][x]);
                    for (GameObject mineNeighbor : countMineNeighbors) {
                        if (mineNeighbor.isMine) gameField[y][x].countMineNeighbors++;
                    }
                }
            }
        }
    }

    private void openTile(int x, int y) {

        GameObject gameObject = gameField[y][x];
        if (gameObject.isFlag||gameObject.isOpen||isGameStopped) return;

        gameObject.isOpen = true;
        countClosedTiles--;
        setCellColor(x, y, Color.GREEN);

        if (!gameObject.isMine) score+=5;

        if (gameObject.isMine) {
            setCellValueEx(x, y, Color.RED, MINE);
            gameOver();
        } else if (gameObject.countMineNeighbors == 0) {
            setCellValue(x, y, "");
            for (GameObject neighbor : getNeighbors(gameObject)) {
                if (!neighbor.isOpen) {
                    openTile(neighbor.x, neighbor.y);
                }
            }
        } else {
            setCellNumber(x, y, gameObject.countMineNeighbors);
        }
        if (countClosedTiles == countMinesOnField&&!gameObject.isMine)win();
        
        setScore(score);
    }

    private void markTile(int x, int y) {
        GameObject gameObject = gameField[y][x];

        if (isGameStopped) return;

        if (gameObject.isOpen || (countFlags == 0 && !gameObject.isFlag)) {
            return;
        }

        if (gameObject.isFlag) {
            countFlags++;
            gameObject.isFlag = false;
            setCellValue(x, y, "");
            setCellColor(x, y, Color.ORANGE);
        } else {
            countFlags--;
            gameObject.isFlag = true;
            setCellValue(x, y, FLAG);
            setCellColor(x, y, Color.YELLOW);
        }
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Игра окночена", Color.BLACK, 14);
    }

    private void win() {
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "Победа !!!", Color.GREEN, 14);
    }

    private void restart(){
        isGameStopped = false;
        score = 0;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;


        setScore(score);
        createGame();
    }
}