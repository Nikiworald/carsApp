package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.calculator.MultiThreadCalculator;
import com.haemimont.carsapp.core.calculator.SingleThreadCalculator;
import com.haemimont.carsapp.core.generator.Generator;
import com.haemimont.carsapp.core.model.Car;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter param:");
        double param = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter count:");
        int cnt = Integer.parseInt(scanner.nextLine());


        long timerStart = System.currentTimeMillis();
        List<Car> carList = Generator.generateCars(cnt);
        System.out.println("Generated "+cnt+" cars for"+(System.currentTimeMillis()-timerStart));

        timerStart = System.currentTimeMillis();
        System.out.println("(SingleThread) sum:"+new SingleThreadCalculator(carList,param).calculate());
        System.out.println("(SingleThread) time to calculate:"+(System.currentTimeMillis()-timerStart));

        timerStart = System.currentTimeMillis();
        System.out.println("(MultiThread) sum:"+new MultiThreadCalculator(carList,param).calculate());
        System.out.println("(MultiThread) time to calculate:"+(System.currentTimeMillis()-timerStart));




    }
}
