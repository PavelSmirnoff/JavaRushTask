package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Hippodrome game
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 08.04.2021
 */
public class Hippodrome {

    public static Hippodrome game;

    private List<Horse> horses = new ArrayList<>();

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) throws InterruptedException {
        List<Horse> horses = new ArrayList<>();
        horses.add(new Horse("Рыжик", 3, 0));
        horses.add(new Horse("Русак", 3, 0));
        horses.add(new Horse("Кобыла", 3, 0));

        game = new Hippodrome(horses);

        game.run();

        game.printWinner();
    }

    public void move() {
        getHorses().forEach(Horse::move);
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void print() {
        getHorses().forEach(Horse::print);
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        Horse winHorse = new Horse("",0,0);
        for (Horse horse : getHorses()) {
            if(horse.getDistance() > winHorse.getDistance()) winHorse = horse;
        }
        return winHorse;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!",getWinner().getName());
    }
}
