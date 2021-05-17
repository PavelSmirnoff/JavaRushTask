package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> instance;

     T newInstance() throws InstantiationException, IllegalAccessException {
        return instance.newInstance();
    }

    public Generator(Class<T> instance) {
        this.instance = instance;
    }
}
