package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.generator.Generator;
import com.haemimont.carsapp.core.model.Car;
import com.haemimont.carsapp.core.tools.ListTools;
import com.haemimont.carsapp.core.tools.QueueTools;

import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        boolean validInput = false;
        HashMap<Integer, Car> hashMap = null;
        Queue queue;
        int processorCnt = Runtime.getRuntime().availableProcessors();
        int param = 0;
        int minYear = 0;
        int maxYear = 0;
        int cnt = 0;
        String model = null;
        long startTimer = 0;
        long endTimer = 0;
        Queue test;
        while (!validInput) {
            System.out.println("input:param,minYear,maxYear,Model,cnt");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputValues = input.split(",");
            if (inputValues.length == 5) {
                try {
                    param = Integer.parseInt(inputValues[0]);
                    minYear = Integer.parseInt(inputValues[1]);
                    maxYear = Integer.parseInt(inputValues[2]);
                    model = inputValues[3];
                    cnt = Integer.parseInt(inputValues[4]);
                    startTimer = System.currentTimeMillis();
                    hashMap = Generator.generateHashMapOfRandomCars(minYear, maxYear, model, cnt);
                    validInput = true;
                    endTimer = System.currentTimeMillis();
                    System.out.println("Time to generate:" + (endTimer - startTimer) + "ms");
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                System.out.println("Wrong number of parameters.Expected 5 provided " + inputValues.length + "\ntry again");
            }
        }//inputs
        queue = QueueTools.fromHashMapToQueue(hashMap);
        test = QueueTools.fromHashMapToQueue(hashMap);
        //single queue
        Thread singleThread = new SingleQueueThread(queue, param, cnt);
        singleThread.start();
        while(singleThread.isAlive()){}
        //multi queue
        startTimer = System.currentTimeMillis();
        double combinedSum = 0;
        List<Queue> queueList = QueueTools.QueueSpreader(test, processorCnt);
        ExecutorService executorService = Executors.newFixedThreadPool(processorCnt);
        for (Queue currentQueue : queueList) {
            CustomQueueCallable callable = new CustomQueueCallable(currentQueue, param);
            Future future = executorService.submit(callable);
            combinedSum += (Double) future.get();
        }
        endTimer = System.currentTimeMillis();
        System.out.println("(multi queue)average sum=" + combinedSum / cnt);
        System.out.println("(multi queue)time to calculate:" + (endTimer - startTimer + "ms"));
        //single list
        List<Car> list = Generator.generateListOfRandomCars(minYear, maxYear, model, cnt);
        List<List> listOfLists = ListTools.ListSpreader(list, processorCnt);
        Thread singleThread2 = new SingleListThread(list, param, cnt);
        singleThread2.start();
        while (singleThread2.isAlive()){}
        //multi list
        listOfLists.size();
        startTimer = System.currentTimeMillis();
        double combinedAverageSum = 0;
        for (List partialList : listOfLists) {
            CustomListCallable callable = new CustomListCallable(partialList, param, cnt);
            Future future = executorService.submit(callable);
            combinedAverageSum += (Double) future.get();
        }
        endTimer = System.currentTimeMillis();
        System.out.println("(multi list)average sum=" + combinedAverageSum / processorCnt);
        System.out.println("(multi list)time to calculate:" + (endTimer - startTimer + "ms"));







    }

}
