package com.javarush.games.racer;

import com.javarush.engine.cell.*;

public class RacerGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int CENTER_X = WIDTH / 2;
    public static final int ROADSIDE_WIDTH = 14;
    private RoadMarking roadMarking;
    private PlayerCar player;

    @Override
    public void initialize() {
        showGrid(false);
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }

    private void createGame() {
        setTurnTimer(40);
        roadMarking = new RoadMarking();
        player = new PlayerCar();
        drawScene();
    }

    private void drawScene() {
        drawField();
        roadMarking.draw(this);
        player.draw(this);
    }

    @Override
    public void setCellColor(int x, int y, Color color) {
        if (x<0||x>=WIDTH||y<0||y>=HEIGHT) return;
        super.setCellColor(x, y, color);
    }

    private void drawField() {
        Color color;
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                if (x == CENTER_X) {
                    color = Color.WHITE;
                }else if (x >= ROADSIDE_WIDTH && x < (WIDTH - ROADSIDE_WIDTH)) {
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
        moveAll();
        drawScene();
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case RIGHT: player.setDirection(Direction.RIGHT); break;
            case LEFT: player.setDirection(Direction.LEFT); break;
        }
    }

    private void moveAll(){
        roadMarking.move(player.speed);
        player.move();
    }

}
