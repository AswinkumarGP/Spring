package com.learn.designPatterns.Behavioural.Observer;

import java.util.*;

public class StockExchange implements Subject {

    private float price = 100;
    Random random = new Random();
    List<Observer> observerList = new ArrayList<>();

    public void start() throws InterruptedException {
        while(true) {
            Thread.sleep(2000);
            price = price + 2 * random.nextFloat() - 1;
            System.out.println(price);
            notifyObserver(price);
        }
    }

    @Override
    public void addObserver(Observer o) {
        observerList.add(o);
    }

    @Override
    public void notifyObserver(float price) {
        for (Observer o : observerList){
            o.update(price);
        }
    }
}
