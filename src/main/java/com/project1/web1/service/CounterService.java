package com.project1.web1.service;

import org.springframework.stereotype.Component;

@Component
public class CounterService {
    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    synchronized public void increment(){
        ++counter;
    }

    private int counter=0;

}
