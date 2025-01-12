package com.learn.designPatterns.Behavioural.Strategy;

public class ImageManager {

    Renderer renderer;

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public void show(){
        this.renderer.showImage();
    }
}
