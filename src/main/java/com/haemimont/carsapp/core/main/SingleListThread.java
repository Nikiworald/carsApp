package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.model.Car;

import java.util.List;

class SingleListThread extends Thread {
    List<Car> list;
    int param;
    int cnt;

    public SingleListThread(List<Car> list, int param, int cnt) {
        this.list = list;
        this.param = param;
        this.cnt = cnt;
    }

    @Override
    public void run() {
        double sum = 0;
        long startTimer = System.currentTimeMillis();
        for (Car currentcar :
                list) {
            sum += currentcar.getPrice() * param;

        }
        System.out.println("(single list)average sum=" + sum / cnt);
        long endTimer = System.currentTimeMillis();
        System.out.println("(single list)Time to calculate:" + (endTimer - startTimer) + "ms");
    }
}