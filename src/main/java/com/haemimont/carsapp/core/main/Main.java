package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.utils.FromListToHashMapWithNoKey;
import com.haemimont.carsapp.core.utils.Search;
import com.haemimont.carsapp.core.calculator.MultiThreadCalculator;
import com.haemimont.carsapp.core.calculator.SingleThreadCalculator;
import com.haemimont.carsapp.core.generator.Generator;
import com.haemimont.carsapp.core.model.Car;
import com.haemimont.carsapp.core.utils.Sort;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SeatingStudents test = new SeatingStudents();
        int[] arr = {12, 2, 6, 7, 11};

        System.out.println(test.SeatingStudents(arr));

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
        Sort.bubbleSort(carList);
        System.out.println("(Sort) time to sort:" + (System.currentTimeMillis() - timerStart) + "ms");


        timerStart = System.currentTimeMillis();
       int result = Search.forSearch(carList,year,model);
        System.out.println("(forEach) time to search:" + (System.currentTimeMillis() - timerStart) + "ms");
        System.out.println("(forEach) cars found:"+result);

//        HashMap<Integer,Car> hashMap = FromListToHashMapWithNoKey.convert(carList);
//        Sort.bubbleSort(hashMap,hashMap.size());

        timerStart=System.currentTimeMillis();
        result = Search.binarySearch(carList,year,model);
        System.out.println("(binarySearch) time to search:" + (System.currentTimeMillis() - timerStart) + "ms");
        System.out.println("(binarySearch)cars found:"+result);

        System.out.println("done");
    }
}
