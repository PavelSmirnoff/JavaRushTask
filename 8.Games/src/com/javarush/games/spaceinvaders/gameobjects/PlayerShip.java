package com.javarush.games.spaceinvaders.gameobjects;

import com.javarush.games.spaceinvaders.*;

/**
 * @author pavelsmirnov
 * @version 1.0
 * дата создания 04.03.2021
 */
public class PlayerShip extends Ship{
    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        setStaticView(ShapeMatrix.PLAYER);

    }
}
