package com.haemimont.carsapp.core.generator;

import com.haemimont.carsapp.core.model.Car;
import com.haemimont.carsapp.core.model.CarTypeA;
import com.haemimont.carsapp.core.model.CarTypeB;
import com.sun.org.apache.xerces.internal.impl.dv.util.ByteListImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Generator {
    public static HashMap<Integer, Car> generateHashMapOfRandomCars(int minYear, int maxYear, String[] models, int cnt) {
        int minPrice = 1000;
        int maxPrice = 10000;
        HashMap<Integer, Car> hashMap = new HashMap<Integer, Car>();
        Random random = new Random();
        for (int i = 1; i <= cnt; i++) {
            int randomInt = random.nextInt(2);
            int randomModelNumber = random.nextInt(models.length);
            int randomYear = random.nextInt(maxYear + 1 - minYear) + minYear;
            double price = (minPrice + (maxPrice - minPrice) * random.nextDouble());
            if (randomInt == 0) {
                CarTypeA carTypeA = new CarTypeA(models[randomModelNumber], randomYear, price);
                hashMap.put(i, carTypeA);
            }
            if (randomInt == 1) {
                CarTypeB carTypeB = new CarTypeB(models[randomModelNumber], randomYear, price);
                hashMap.put(i, carTypeB);
            }
        }return hashMap;
    }
    public static HashMap<Integer, Car> generateHashMapOfRandomCars(int minYear, int maxYear, String model, int cnt) {
        int minPrice = 1000;
        int maxPrice = 10000;
        HashMap<Integer, Car> hashMap = new HashMap<Integer, Car>();
        Random random = new Random();
        for (int i = 1; i <= cnt; i++) {
            int randomInt = random.nextInt(2);
            int randomYear = random.nextInt(maxYear + 1 - minYear) + minYear;
            double price = (minPrice + (maxPrice - minPrice) * random.nextDouble());
            if (randomInt == 0) {
                CarTypeA carTypeA = new CarTypeA(model, randomYear, price);
                hashMap.put(i, carTypeA);
            }
            if (randomInt == 1) {
                CarTypeB carTypeB = new CarTypeB(model, randomYear, price);
                hashMap.put(i, carTypeB);
            }
        }return hashMap;
    }
    public static List<Car> generateListOfRandomCars(int minYear, int maxYear, String model, int cnt) {
        int minPrice = 1000;
        int maxPrice = 10000;
        List<Car> list = new ArrayList<Car>();

        Random random = new Random();
        for (int i = 1; i <= cnt; i++) {
            int randomInt = random.nextInt(2);
            int randomYear = random.nextInt(maxYear + 1 - minYear) + minYear;
            double price = (minPrice + (maxPrice - minPrice) * random.nextDouble());
            if (randomInt == 0) {
                CarTypeA carTypeA = new CarTypeA(model, randomYear, price);
                list.add(carTypeA);
            }
            if (randomInt == 1) {
                CarTypeB carTypeB = new CarTypeB(model, randomYear, price);
                list.add(carTypeB);
            }
        }return list;
    }

}
