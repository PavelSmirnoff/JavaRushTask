package com.javarush.games.racer;

import com.javarush.engine.cell.*;
import com.javarush.games.racer.road.RoadManager;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private static final int RACE_GOAL_CARS_COUNT = 40;
    private int score;
    private RoadMarking roadMarking;
    private PlayerCar player;
    private RoadManager roadManager;
    private boolean isGameStopped;
    private FinishLine finishLine;
    private ProgressBar progressBar;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        isGameStopped = false;
        setTurnTimer(40);
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        roadManager = new RoadManager();
        finishLine = new FinishLine();
        progressBar = new ProgressBar(RACE_GOAL_CARS_COUNT);
        score = 3500;
        drawScene();
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
        roadManager.draw(this);
        finishLine.draw(this);
        progressBar.draw(this);
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT) return;
        super.setCellColor(x, y, color);
    }

    private void drawField() {
        Color color;
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x == CENTER_X) {
                    color = Color.WHITE;
                } else if (x >= ROADSIDE_WIDTH && x < (WIDTH - ROADSIDE_WIDTH)) {
                    color = Color.DARKGRAY;
                } else {
                    color = Color.GREEN;
                }
                setCellColor(x, y, color);
            }
        }
    }

    @Override
    public void onTurn(int step) {
        if (roadManager.checkCrush(player)) {
            gameOver();
            drawScene();
            return;
        }
        roadManager.generateNewRoadObjects(this);
        if (roadManager.getPassedCarsCount() >= RACE_GOAL_CARS_COUNT) finishLine.show();
        if(finishLine.isCrossed(player)) {
            win();
            drawScene();
            return;
        }
        score -= 5;
        setScore(score);
        moveAll();
        drawScene();
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.LEFT && player.getDirection() == Direction.LEFT) player.setDirection(Direction.NONE);
        if (key == Key.RIGHT && player.getDirection() == Direction.RIGHT) player.setDirection(Direction.NONE);
        if (key == Key.UP) player.speed = 1;
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key) {
            case SPACE:
                if (isGameStopped) createGame();
                break;
            case RIGHT:
                player.setDirection(Direction.RIGHT);
                break;
            case LEFT:
                player.setDirection(Direction.LEFT);
                break;
            case UP:
                player.speed = 2;
                break;
        }
    }

    private void moveAll() {
        roadMarking.move(player.speed);
        roadManager.move(player.speed);
        finishLine.move(player.speed);
        progressBar.move(roadManager.getPassedCarsCount());
        player.move();
    }

    private void gameOver() {
        isGameStopped = true;
        showMessageDialog(Color.RED, "Looser", Color.WHITE, 100);
        stopTurnTimer();
        player.stop();
    }

    private void win() {
        isGameStopped = true;
        stopTurnTimer();
        showMessageDialog(Color.WHITE, "WIN", Color.GREEN, 75);
    }
}
