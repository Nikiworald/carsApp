package com.haemimont.carsapp.core.calculator;

import com.haemimont.carsapp.core.model.Car;

import java.util.List;
import java.util.concurrent.*;

public class SingleThreadCalculator implements Calculator, Callable<Double> {
    private final List<Car> carList;
    private final double param;

    public SingleThreadCalculator(List<Car> carList, double param) {
        this.carList = carList;
        this.param = param;
    }

    @Override
    public double calculate() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Double> future = executor.submit(this);
        executor.shutdown();
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public Double call() {
        double sum = 0d;
        for (Car car : carList) {
            sum += car.getPrice() * param;
        }
        return sum / carList.size();
    }
}
