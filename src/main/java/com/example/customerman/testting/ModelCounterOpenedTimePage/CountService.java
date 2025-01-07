package com.example.customerman.testting.ModelCounterOpenedTimePage;

import org.springframework.stereotype.Service;

@Service
public class CountService {
    private final Count count;

    public CountService() {
        this.count = new Count(0);
    }

    public Count getCount() {
        return count;
    }

    public void incrementCount() {
        count.increment();
    }
}