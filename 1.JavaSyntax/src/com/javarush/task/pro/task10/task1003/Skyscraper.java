package com.javarush.task.pro.task10.task1003;

/* 
Построим новый бизнес-комплекс JavaRush Business Center
*/

public class Skyscraper {
    private int floorsCount;
    private String developer;

    //напишите тут ваш код
    public Skyscraper(){
        this.floorsCount = 5;
        this.developer = "JavaRushDevelopment";
    }
    
    public Skyscraper(int floorsCount, String developer){
        this.floorsCount = floorsCount;
        this.developer = developer;
    }

    public static void main(String[] args) {
        var skyscraper = new Skyscraper();
        var skyscraperUnknown = new Skyscraper(50, "Неизвестно");
    }
}
