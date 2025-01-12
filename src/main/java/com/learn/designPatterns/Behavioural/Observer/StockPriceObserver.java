package com.learn.designPatterns.Behavioural.Observer;


import java.sql.SQLOutput;

public class StockPriceObserver implements Observer {

    private float price;
    Subject subject;

    public StockPriceObserver(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void update(float price) {
        this.price = price;
        if (price > 105){
            System.out.println("Sell");
        } else if(price < 95) {
            System.out.println("Buy");
        }
    }
}
