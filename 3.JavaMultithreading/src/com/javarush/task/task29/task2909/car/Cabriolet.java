package com.javarush.task.task29.task2909.car;

public class Cabriolet extends Car{
    public Cabriolet(int numberOfPassengers) {
        super(numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }

}
