package com.javarush.games.minigames.mini05;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;

import java.util.ArrayList;

public class RainbowGame extends Game {
    @Override
    public void initialize(){
        setScreenSize(10, 7);
        ArrayList<Color> color = new ArrayList<>();
        color.add(Color.RED);
        color.add(Color.ORANGE);
        color.add(Color.YELLOW);
        color.add(Color.GREEN);
        color.add(Color.BLUE);
        color.add(Color.INDIGO);
        color.add(Color.VIOLET);

        for(int y = 0; y < 7; y++){
            for(int x = 0; x < 10; x++){
                setCellColor(x, y, color.get(y));
            }
        }
    }
}
