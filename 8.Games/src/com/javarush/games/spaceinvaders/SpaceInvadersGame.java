package com.javarush.games.spaceinvaders;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;
import com.javarush.games.spaceinvaders.gameobjects.Bullet;
import com.javarush.games.spaceinvaders.gameobjects.EnemyFleet;
import com.javarush.games.spaceinvaders.gameobjects.PlayerShip;
import com.javarush.games.spaceinvaders.gameobjects.Star;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pavelsmirnov
 */
public class SpaceInvadersGame extends Game {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public static final int COMPLEXITY = 5;
    private static final int PLAYER_BULLETS_MAX = 1;
    private List<Star> stars;
    private EnemyFleet enemyFleet;
    private List<Bullet> enemyBullets;
    private List<Bullet> playerBullets;
    private PlayerShip playerShip;
    private boolean isGameStopped;
    private int animationsCount;

    private int score;


    @Override
    public void initialize() {
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }


    private void createGame() {
        setTurnTimer(40);
        createStars();
        enemyFleet = new EnemyFleet();
        enemyBullets = new ArrayList<>();
        playerBullets = new ArrayList<>();
        playerShip = new PlayerShip();
        isGameStopped = false;
        animationsCount = 0;
        score = 0;
        drawScene();
    }

    private void drawScene() {
        drawField();
        enemyBullets.forEach(x -> x.draw(this));
        playerBullets.forEach(x -> x.draw(this));
        enemyFleet.draw(this);
        playerShip.draw(this);
    }

    private void drawField() {
        for (int x = 0; x < WIDTH; x++) {
            for (int y = 0; y < HEIGHT; y++) {
                setCellValueEx(x, y, Color.GREY, "");
            }
        }
        for (Star star : stars) {
            star.draw(this);
        }
    }

    private void createStars() {
        stars = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            stars.add(new Star(getRandomNumber(WIDTH), getRandomNumber(HEIGHT)));
        }
    }

    @Override
    public void onTurn(int step) {
        moveSpaceObjects();
        check();
        Bullet bullet = enemyFleet.fire(this);
        if (bullet != null) enemyBullets.add(bullet);

        setScore(score);

        drawScene();
    }

    private void moveSpaceObjects() {
        enemyFleet.move();
        enemyBullets.forEach(Bullet::move);
        playerBullets.forEach(Bullet::move);
        playerShip.move();
    }

    private void removeDeadBullets() {
        enemyBullets.removeIf(bullet -> !bullet.isAlive || bullet.y >= (HEIGHT - 1));
        playerBullets.removeIf(bullet -> !bullet.isAlive || bullet.y + bullet.height < 0);
    }

    @Override
    public void setCellValueEx(int x, int y, Color cellColor, String value) {
        if (x < 0 || x > WIDTH - 1 || y < 0 || y > HEIGHT - 1) return;
        super.setCellValueEx(x, y, cellColor, value);
    }

    private void check() {
        playerShip.verifyHit(enemyBullets);
        enemyFleet.verifyHit(playerBullets);
        enemyFleet.deleteHiddenShips();
        if (enemyFleet.getBottomBorder() >= playerShip.y) playerShip.kill();
        if (enemyFleet.getShipsCount() == 0){
            playerShip.win();
            this.stopGameWithDelay();
        }
            removeDeadBullets();
        if (!playerShip.isAlive) stopGameWithDelay();

        score += enemyFleet.verifyHit(enemyBullets);
    }

    @Override
    public void onKeyPress(Key key) {
        if (key == Key.SPACE && isGameStopped) {
            createGame();
            return;
        }
        if (key == Key.SPACE) {
            Bullet bullet = playerShip.fire();
            if (bullet != null && playerBullets.size() < PLAYER_BULLETS_MAX) {
                playerBullets.add(bullet);
            }
        }
        if (key == Key.LEFT) playerShip.setDirection(Direction.LEFT);
        if (key == Key.RIGHT) playerShip.setDirection(Direction.RIGHT);
    }

    @Override
    public void onKeyReleased(Key key) {
        if ((key == Key.LEFT && playerShip.getDirection() == Direction.LEFT) ||
                (key == Key.RIGHT && playerShip.getDirection() == Direction.RIGHT)) {
            playerShip.setDirection(Direction.UP);
        }
    }

    private void stopGame(boolean isWin) {
        isGameStopped = true;
        stopTurnTimer();
        if (isWin) showMessageDialog(Color.WHITE, "Is Win", Color.GREEN, 75);
        else showMessageDialog(Color.WHITE, "Is NOT Win", Color.RED, 75);
    }

    private void stopGameWithDelay() {
        animationsCount++;
        if (animationsCount >= 10) stopGame(playerShip.isAlive);
    }
}
