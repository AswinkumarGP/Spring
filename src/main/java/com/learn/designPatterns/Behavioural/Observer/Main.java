package com.learn.designPatterns.Behavioural.Observer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        StockExchange stockExchange = new StockExchange();
        StockPriceObserver stockPriceObserver = new StockPriceObserver(stockExchange);
        stockExchange.addObserver(stockPriceObserver);
        stockExchange.start();
    }
}
