package com.learn.defaultStaticMethods;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        DefaultStatic defaultStatic = new DefaultStaticMethodsExample();
        System.out.println(defaultStatic.sum(Arrays.asList(1, 3,5)));
        System.out.println(defaultStatic.size(Arrays.asList(1, 3,5)));
        System.out.println(DefaultStatic.notNull(Arrays.asList(1, 3,5)));

    }
}
