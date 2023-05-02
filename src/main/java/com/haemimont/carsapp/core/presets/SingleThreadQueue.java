package com.haemimont.carsapp.core.presets;

import com.haemimont.carsapp.core.customThreads.SingleThreadForQueue;

import java.util.Queue;

public class SingleThreadQueue {
    public static Thread start(Queue queue,int param,int cnt){
        Queue finalQueue = queue;
        Thread singleThread = new SingleThreadForQueue(finalQueue, param, cnt);
        singleThread.start();
        return singleThread;

    }
}
