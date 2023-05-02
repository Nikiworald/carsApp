package com.haemimont.carsapp.core.customThreads;

import com.haemimont.carsapp.core.model.Car;

import java.util.Queue;

public class SingleThreadForQueue extends Thread {
    Queue queue;
    int param;
    int cnt;

    public SingleThreadForQueue(Queue queue, int param, int cnt) {
        this.queue = queue;
        this.param = param;
        this.cnt = cnt;
    }

    @Override
    public void run() {
        Queue copy = this.queue;
        double sum = 0;
        long startTimer = System.currentTimeMillis();
        while (!copy.isEmpty()) {
            Car car = (Car) copy.poll();
            sum += car.getPrice() * param;
        }
        System.out.println("(single queue)average sum=" + sum / cnt);
        long endTimer = System.currentTimeMillis();
        System.out.println("(single queue)Time to calculate:" + (endTimer - startTimer) + "ms");
    }
}