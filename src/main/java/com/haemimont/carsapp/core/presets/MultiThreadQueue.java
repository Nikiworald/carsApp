package com.haemimont.carsapp.core.presets;

import com.haemimont.carsapp.core.customCallable.CustomCallableForQueue;
import com.haemimont.carsapp.core.tools.QueueTools;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadQueue {
    public static void start(Queue queue,int param,int cnt){
        Queue finalQueue = queue;
        long startTimer = System.currentTimeMillis();
        double combinedSum = 0;
        int processorCnt = Runtime.getRuntime().availableProcessors();
        List<Queue> queueList = QueueTools.QueueSpreader(finalQueue, processorCnt);
        ExecutorService executorService = Executors.newFixedThreadPool(processorCnt);
        for (Queue currentQueue : queueList) {
            CustomCallableForQueue callable = new CustomCallableForQueue(currentQueue, param);
            Future future = executorService.submit(callable);
            try {
                combinedSum += (Double) future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        long endTimer = System.currentTimeMillis();
        System.out.println("(multi queue)average sum=" + combinedSum / cnt);
        System.out.println("(multi queue)time to calculate:" + (endTimer - startTimer + "ms"));
    }
}
