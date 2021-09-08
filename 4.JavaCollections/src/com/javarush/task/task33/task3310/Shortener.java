package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        Long id = storageStrategy.getKey(string);
        if (id != null) return id;

        lastId++;
        storageStrategy.put(lastId, string);
        return lastId;
    }

    public String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
