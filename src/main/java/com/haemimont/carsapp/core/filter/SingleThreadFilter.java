package com.haemimont.carsapp.core.filter;

import com.haemimont.carsapp.core.model.Car;

import java.util.List;
import java.util.concurrent.*;

public class SingleThreadFilter implements CarFilter, Callable<List<Car>> {
    private final List<Car> listOfCars;
    private final int year;
    private final String model;
    public SingleThreadFilter(List<Car> listOfCars, int year, String model){
        this.listOfCars = listOfCars;
        this.year = year;
        this.model = model;
    }


    @Override
    public List<Car> filterCarList() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<Car>> future = executor.submit(this);
        executor.shutdown();
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> call() throws Exception {
        listOfCars.removeIf(car -> car.getYear() != year && !car.getModel().equals(model));
        return listOfCars;
    }
}
