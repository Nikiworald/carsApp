package com.haemimont.carsapp.core.tools;

import java.util.*;

public class QueueTools {
    public static Queue fromHashMapToQueue(HashMap hashMap) {
        Queue queue = new ArrayDeque();
        hashMap.forEach((key, value) -> {
            queue.add((hashMap.get(key)));
        });
        return queue;
    }

    public static List<Queue> QueueSpreader(Queue finalQueue, int cntOfQueues) {
        Queue queue = finalQueue;
        int size = queue.size();
        List<Queue> queueList = new ArrayList<>();
        for (int i = 0; i < cntOfQueues; i++) {
            Queue partialQueue = new ArrayDeque();
            for (int n = 0; n < size / cntOfQueues; n++) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    partialQueue.add(queue.poll());
                }
            }
            if (i == (cntOfQueues - 1)) {
                while (!queue.isEmpty()) {
                    partialQueue.add(queue.poll());
                }
            }
            queueList.add(partialQueue);
        }
        return queueList;

    }
}
