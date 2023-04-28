package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.model.Car;

import java.util.Queue;

class SingleQueueThread extends Thread {
    Queue queue;
    int param;
    int cnt;

    public SingleQueueThread(Queue queue, int param, int cnt) {
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