package com.haemimont.carsapp.core.presets;

import com.haemimont.carsapp.core.customThreads.SingleThreadForList;

import java.util.List;

public class SingleThreadList {
    public static Thread start(List list,int param,int cnt){
        Thread singleThread = new SingleThreadForList(list, param, cnt);
        singleThread.start();
        return singleThread;
    }
}
