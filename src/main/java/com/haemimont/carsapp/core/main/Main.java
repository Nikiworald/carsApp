package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.calculator.MultiThreadCalculator;
import com.haemimont.carsapp.core.calculator.SingleThreadCalculator;
import com.haemimont.carsapp.core.generator.Generator;
import com.haemimont.carsapp.core.model.Car;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter param:");
        double param = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter count:");
        int cnt = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter year filter(1999-2023)");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter model\n" + Arrays.toString(Generator.getModels()));
        String model = scanner.nextLine();


        long timerStart = System.currentTimeMillis();
        List<Car> carList = Generator.generateCars(cnt);
        System.out.println("Generated " + cnt + " cars for " + (System.currentTimeMillis() - timerStart) + "ms");

        timerStart = System.currentTimeMillis();
        System.out.println("(SingleThread) average price:" + new SingleThreadCalculator(carList, param).calculate());
        System.out.println("(SingleThread) time to calculate:" + (System.currentTimeMillis() - timerStart) + "ms");

        timerStart = System.currentTimeMillis();
        System.out.println("(MultiThread) average price:" + new MultiThreadCalculator(carList, param).calculate());
        System.out.println("(MultiThread) time to calculate:" + (System.currentTimeMillis() - timerStart) + "ms");


        timerStart = System.currentTimeMillis();
        carList.removeIf(car -> car.getYear() != year && !car.getModel().equals(model));
        System.out.println("Filtered " + cnt + " cars.Cars left:" + carList.size());
        System.out.println("(SingleThread) time to filter:" + (System.currentTimeMillis() - timerStart) + "ms");


    }
}
