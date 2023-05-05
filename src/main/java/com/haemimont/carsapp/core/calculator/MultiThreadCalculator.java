package com.haemimont.carsapp.core.calculator;

import com.haemimont.carsapp.core.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadCalculator implements Calculator {
    private final List<Car> carList;
    private final double param;

    public MultiThreadCalculator(List<Car> carList, double param) {
        this.carList = carList;
        this.param = param;
    }

    @Override
    public double calculate() {
        double sum = 0d;
        int processorCnt = Runtime.getRuntime().availableProcessors();
        int partitionSize = carList.size() / processorCnt;
        ExecutorService executorService = Executors.newFixedThreadPool(processorCnt);
        List<Future<Double>> futureList = new ArrayList<>();
        for (int i = 0; i < carList.size(); i += partitionSize) {
            List<Car> partialList = carList.subList(i, Math.min(i + partitionSize, carList.size()));
            futureList.add(executorService.submit(new SingleThreadCalculator(partialList, param)));
        }
        for (Future<Double> future : futureList) {
            try {
                sum += future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        return sum / processorCnt;
    }
}
