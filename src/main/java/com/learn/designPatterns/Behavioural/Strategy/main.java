package com.learn.designPatterns.Behavioural.Strategy;

public class main {

    public static void main(String[] args) {
        ImageManager imageManager = new ImageManager();
        imageManager.setRenderer(new SmartPhoneRenderer());
        imageManager.show();
    }
}
