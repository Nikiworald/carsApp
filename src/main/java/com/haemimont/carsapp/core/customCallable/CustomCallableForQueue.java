package com.haemimont.carsapp.core.customCallable;

import com.haemimont.carsapp.core.model.Car;

import java.util.Queue;
import java.util.concurrent.Callable;

public class CustomCallableForQueue implements Callable {
    Car car;
    int param;
    double sum;
    Queue<Car> queue;
    int cnt;

    public CustomCallableForQueue(Queue<Car> queue, int param) {
        this.param = param;
        this.queue = queue;
    }

    @Override
    public Double call() throws Exception {
        sum = 0;
        while (!queue.isEmpty()) {
            car = queue.poll();
            sum += car.getPrice() * param;
        }
        return sum;
    }

}
