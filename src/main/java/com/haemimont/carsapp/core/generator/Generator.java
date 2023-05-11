package com.haemimont.carsapp.core.generator;

import com.haemimont.carsapp.core.model.Car;
import com.haemimont.carsapp.core.model.CarTypeA;
import com.haemimont.carsapp.core.model.CarTypeB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    private static final int MIN_YEAR = 1999;
    private static final int MAX_YEAR = 2023;
    private static final double MIN_PRICE = 1000;
    private static final double MAX_PRICE = 10000;

    public static String[] getModels() {
        return models;
    }

    static String[] models = {"Mazda", "BMW", "Audi", "Chevrolet", "Lada", "Bugatti"};

    public static String getRandomModel() {
        return models[ThreadLocalRandom.current().nextInt(models.length)];
    }

    public static double getRandomPrice() {
        return ThreadLocalRandom.current().nextDouble(MIN_PRICE, MAX_PRICE);
    }

    public static int getRandomYear() {
        return ThreadLocalRandom.current().nextInt(MIN_YEAR, MAX_YEAR);
    }

    public static List<Car> generateCars(int cnt) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            if (ThreadLocalRandom.current().nextInt(2) == 1) {

                Car car = new CarTypeA(getRandomModel(), getRandomYear(), getRandomPrice());
                carList.add(car);
            } else {
                Car car = new CarTypeB(getRandomModel(), getRandomYear(), getRandomPrice());
                carList.add(car);
            }
        }
        return carList;
    }

}
