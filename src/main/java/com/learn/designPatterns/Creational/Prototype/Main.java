package com.learn.designPatterns.Creational.Prototype;

public class Main {

    public static void main(String[] args) {

        Prototype prototype = new Prototype();
        prototype.setName("Aswin");

        Object obj = (Prototype) prototype.clone();
        System.out.println(((Prototype) obj).getName());

    }
}
