package com.javarush.games.minigames.mini08;

import com.javarush.engine.cell.Color;
import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Key;

public class KeyboardGame extends Game {

    @Override
    public void initialize() {
        setScreenSize(3, 3);

        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                setCellColor(x, y, Color.WHITE);
            }
        }
    }
    @Override
    public void onKeyPress(Key key) {
        // При нажатии пробела, центральная клетка становится желтой
        if (key == Key.UP) {
            setCellColor(0, 0, Color.GREEN);
            setCellColor(1, 0, Color.GREEN);
            setCellColor(2, 0, Color.GREEN);
        }
        if (key == Key.DOWN) {
            setCellColor(0, 2, Color.GREEN);
            setCellColor(1, 2, Color.GREEN);
            setCellColor(2, 2, Color.GREEN);
        }
        if (key == Key.LEFT) {
            setCellColor(0, 0, Color.GREEN);
            setCellColor(0, 1, Color.GREEN);
            setCellColor(0, 2, Color.GREEN);
        }
        if (key == Key.RIGHT) {
            setCellColor(2, 0, Color.GREEN);
            setCellColor(2, 1, Color.GREEN);
            setCellColor(2, 2, Color.GREEN);
        }
    }

    @Override
    public void onKeyReleased(Key key) {
        if (key == Key.RIGHT||key == Key.LEFT||key == Key.DOWN||key == Key.UP) {
            for (int x = 0; x < 3; x++) {
                for (int y = 0; y < 3; y++) {
                    setCellColor(x, y, Color.WHITE);
                }
            }
        }
    }

}
