package com.learn.defaultStaticMethods;

import java.util.List;

public interface DefaultStatic {

    int sum(List<Integer> list);

    default int size(List<Integer> list){
        return list.size();
    }

    static boolean notNull(List<Integer> list){
        return list != null && list.size()>0;
    }
}
