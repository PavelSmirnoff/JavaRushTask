package com.javarush.games.spaceinvaders.gameobjects;

/**
 * @author pavelsmirnov
 */
public class Ship extends GameObject{
    public boolean isAlive = true;

    public Ship(double x, double y) {
        super(x, y);
    }

    public void setStaticView(int[][] viewFrame){
        super.setMatrix(viewFrame);
    }

    public Bullet fire(){
        return null;
    }

    public void kill(){
        isAlive = false;
    }
}
