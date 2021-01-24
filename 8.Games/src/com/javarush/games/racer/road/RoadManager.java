package com.javarush.games.racer.road;

import com.javarush.engine.cell.Game;
import com.javarush.games.racer.*;

import java.util.ArrayList;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<>();


    private RoadObject createRoadObject(RoadObjectType type, int x, int y){
        if (type == RoadObjectType.THORN) return new Thorn( x, y);
        else return null;
    }

    private void addRoadObject(RoadObjectType type, Game game){
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject roadObject = createRoadObject(type, x, y);
        if (roadObject != null) items.add(roadObject);
    }

    public void draw(Game game) {
        for (RoadObject roadObject: items) {
            roadObject.draw(game);
        }
    }
    public void move(int boost){
        for (RoadObject roadObject: items) {
            roadObject.move(boost + roadObject.speed);
        }
    }
}
