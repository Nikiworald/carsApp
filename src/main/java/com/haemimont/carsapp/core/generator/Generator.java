package com.haemimont.carsapp.core.generator;

import com.haemimont.carsapp.core.model.Car;
import com.haemimont.carsapp.core.model.CarTypeA;
import com.haemimont.carsapp.core.model.CarTypeB;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {
    static int minYear = 1999;
    static int maxYear = 2023;
    static double minPrice = 1000;
    static double maxPrice = 10000;
    static String[] models = {"Mazda", "BMW", "Audi", "Chevrolet", "Lada", "Bugatti"};

    public static String getRandomModel() {
        return models[ThreadLocalRandom.current().nextInt(models.length)];
    }

    public static double getRandomPrice() {
        return ThreadLocalRandom.current().nextDouble(minPrice, maxPrice);
    }

    public static int getRandomYear() {
        return ThreadLocalRandom.current().nextInt(minYear, maxYear);
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
