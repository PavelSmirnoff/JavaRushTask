package com.javarush.task.task33.task3310.strategy;

public class OurHashMapStorageStrategy implements StorageStrategy {

    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    final int hash(Long k) {
        return k.hashCode();
    }

    static int indexFor(int hash, int length) {
        return hash & (length - 1);
    }

    private Entry getEntry(Long key) {
        return null;
    }

    private void resize(int newCapacity) {

    }

    private void transfer(Entry[] newTable) {

    }

    private void addEntry(int hash, Long key, String value, int bucketIndex){

    }

    private void createEntry(int hash, Long key, String value, int bucketIndex){

    }

    @Override
    public boolean containsKey(Long key) {
        for (Entry entry :table) {
            if(entry.getKey().equals(key)) return true;
        }
        return false;
    }

    @Override
    public boolean containsValue(String value) {

        return false;
    }

    @Override
    public void put(Long key, String value) {

    }

    @Override
    public Long getKey(String value) {
        return null;
    }

    @Override
    public String getValue(Long key) {
        return null;
    }
}
