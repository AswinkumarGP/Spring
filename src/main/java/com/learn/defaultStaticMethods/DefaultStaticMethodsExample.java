package com.learn.defaultStaticMethods;

import java.util.List;

public class DefaultStaticMethodsExample implements DefaultStatic{

    @Override
    public int sum(List<Integer> list) {
        return list.stream().reduce(0,(a,b) -> a+b);
    }

    public int size(List<Integer> list){
        return list.size()+1;
    }
}
