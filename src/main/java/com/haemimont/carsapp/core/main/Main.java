package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.generator.Generator;
import com.haemimont.carsapp.core.model.Car;
import com.haemimont.carsapp.core.presets.MultiThreadList;
import com.haemimont.carsapp.core.presets.MultiThreadQueue;
import com.haemimont.carsapp.core.presets.SingleThreadList;
import com.haemimont.carsapp.core.presets.SingleThreadQueue;
import com.haemimont.carsapp.core.tools.CarMakeModel;
import com.haemimont.carsapp.core.tools.InputFromUser;
import com.haemimont.carsapp.core.tools.ListTools;
import com.haemimont.carsapp.core.tools.QueueTools;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        HashMap<Integer, Car> hashMap = null;
        Map<String, Integer> inputMap = InputFromUser.getInputs();
        int param = inputMap.get("param");
        int minYear = inputMap.get("minYear");
        int maxYear = inputMap.get("maxYear");
//        String model = String.valueOf(inputMap.get("model"));
        int cnt = inputMap.get("cnt");
        long startTimer = System.currentTimeMillis();
        hashMap = Generator.generateHashMapOfRandomCars(minYear, maxYear, CarMakeModel.getRandomMake(), cnt);
        long endTimer = System.currentTimeMillis();
        System.out.println("Time to generate:" + (endTimer - startTimer) + "ms");
        //inputs
        Queue queue = QueueTools.fromHashMapToQueue(hashMap);
        Queue queue1 = QueueTools.fromHashMapToQueue(hashMap);
        List<Car> list = ListTools.fromHashMapToList(hashMap);
        //single queue
       Thread thread= SingleThreadQueue.start(queue, param, cnt);
       while(thread.isAlive()){}
        //multi queue
        MultiThreadQueue.start(queue1, param, cnt);
        //single list
        Thread thread2= SingleThreadList.start(list, param, cnt);
        while(thread2.isAlive()){}

        //multi list
        MultiThreadList.start(list, param, cnt);

    }
}