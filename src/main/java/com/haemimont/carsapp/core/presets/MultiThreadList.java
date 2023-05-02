package com.haemimont.carsapp.core.presets;

import com.haemimont.carsapp.core.customCallable.CustomCallableForList;
import com.haemimont.carsapp.core.tools.ListTools;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiThreadList {
    public static void start(List list,int param,int cnt){
       long startTimer = System.currentTimeMillis();
       int processorCnt = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(processorCnt);
       List<List> listOfLists = ListTools.ListSpreader(list,processorCnt);
        double combinedAverageSum = 0;
        for (List partialList : listOfLists) {
            CustomCallableForList callable = new CustomCallableForList(partialList, param, cnt);
            Future future = executorService.submit(callable);
            try {
                combinedAverageSum += (Double) future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
       long endTimer = System.currentTimeMillis();
        System.out.println("(multi list)average sum=" + combinedAverageSum / processorCnt);
        System.out.println("(multi list)time to calculate:" + (endTimer - startTimer + "ms"));
    }
}
