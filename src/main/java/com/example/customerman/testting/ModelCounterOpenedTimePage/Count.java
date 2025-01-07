package com.example.customerman.testting.ModelCounterOpenedTimePage;

public class Count {
    int count;

    public Count(int count) {
        this.count = count;
    }

    public Count() {};

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void increment() {
        count++;
    }
}
