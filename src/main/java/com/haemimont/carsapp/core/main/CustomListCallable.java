package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.model.Car;

import java.util.List;
import java.util.concurrent.Callable;

public class CustomListCallable implements Callable {
    int param;
    double sum;
    List<Car> list;
    int cnt;

    public CustomListCallable(List<Car> list, int param, int cnt) {
        this.param = param;
        this.list = list;
        this.cnt = cnt;
    }

    @Override
    public Double call() throws Exception {


        sum = 0;
        for (Car currentCar :
                list) {
            sum += currentCar.getPrice() * param;
        }
//        long time =System.currentTimeMillis();
//        System.out.println(time);
        return sum / list.size();
    }

}