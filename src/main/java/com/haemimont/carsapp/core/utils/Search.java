package com.haemimont.carsapp.core.utils;

import com.haemimont.carsapp.core.model.Car;

import java.util.List;

public class Search {


    public static int binarySearchByYear(List<Car> list, int year) {//fixme it gets stuck at line 20

        int firstIndex = 0;
        int lastIndex = list.size() - 1;
        int cnt = 0;

        // termination condition (element isn't present)
        while(firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            // if the middle element is our goal element, return its index
            if (list.get(middleIndex).getYear() == year) {
//                return middleIndex;
                cnt++;
            }

            // if the middle element is smaller
            // point our index to the middle+1, taking the first half out of consideration
            else if (list.get(middleIndex).getYear() <= year) {
                firstIndex = middleIndex + 1;


            }
            // if the middle element is bigger
            // point our index to the middle-1, taking the second half out of consideration
            else if (list.get(middleIndex).getYear() >= year) {
                lastIndex = middleIndex - 1;

            }
        }
        return cnt;
    }
    public static int forSearch(List<Car> list,int year,String model){
        int cnt =0;
        for (Car car : list) {
            if ((car.getYear() == year) && (car.getModel().equals(model))) {
                cnt++;
            }
        }
        return cnt;
    }



}
