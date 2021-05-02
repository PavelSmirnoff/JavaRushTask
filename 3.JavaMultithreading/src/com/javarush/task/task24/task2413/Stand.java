package com.javarush.task.task24.task2413;

public class Stand extends BaseObject{
    private double speed;
    private double direction;

    @Override
    void draw(Canvas canvas) {
        
    }

    @Override
    void move() {
        x += (direction * speed);
    }

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public void moveLeft(){
        direction = -1;
    }

    public void moveRight() {
        direction = 1;
    }
}
