package com.learn.designPatterns.Behavioural.Observer;

public interface Subject {
    void addObserver(Observer o);
    void notifyObserver(float price);
}
