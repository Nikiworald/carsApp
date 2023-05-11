package com.haemimont.carsapp.core.filter;

import com.haemimont.carsapp.core.calculator.SingleThreadCalculator;
import com.haemimont.carsapp.core.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadFilter implements CarFilter {
    private final List<Car> listOfCars;
    private final int year;
    private final String model;
    public MultiThreadFilter(List<Car> listOfCars, int year, String model){
        this.listOfCars = listOfCars;
        this.year = year;
        this.model = model;
    }

    @Override
    public List<Car> filterCarList() {
        List<Car> finalListOfCars = new ArrayList<>();
        int processorCnt = Runtime.getRuntime().availableProcessors();
        int partitionSize = listOfCars.size() / processorCnt;
        ExecutorService executorService = Executors.newFixedThreadPool(processorCnt);
        List<Future<List<Car>>> futureList = new ArrayList<>();
        for (int i = 0; i < listOfCars.size(); i += partitionSize) {
            List<Car> partialList = listOfCars.subList(i, Math.min(i + partitionSize, listOfCars.size()));
            futureList.add(executorService.submit(new SingleThreadFilter(partialList,year,model)));
        }
        for (Future<List<Car>> future : futureList) {
            try {
                finalListOfCars.add((Car) future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
        return finalListOfCars;

    }
}
