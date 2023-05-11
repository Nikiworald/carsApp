package com.haemimont.carsapp.core.utils;

import com.haemimont.carsapp.core.model.Car;

import java.util.HashMap;
import java.util.List;

public class Sort {
    static public void bubbleSort(List<Car> carList,int n)
    {
        Car tempCar1;
        if (n == 1)                     //passes are done
        {
            return;
        }

        for (int i=0; i<n-1; i++)       //iteration through unsorted elements
        {
            if (carList.get(i).getYear() >= carList.get(i + 1).getYear())      //check if the elements are in order
            {
                tempCar1 = carList.get(i);
                carList.set(i,carList.get(i+1));
                carList.set(i+1,tempCar1);
            }
        }

        bubbleSort(carList, n-1);           //one pass done, proceed to the next
    }
    public static void bubbleSort(HashMap<Integer,Car> carHashMap,int n){
        if (n == 1)                     //passes are done
        {
            return;
        }

        for (int i=0; i<n-1; i++)       //iteration through unsorted elements
        {
            if (carHashMap.get(i).getYear() > carHashMap.get(i + 1).getYear())      //check if the elements are in order
            {
                Car tempCar1 = carHashMap.get(i);
                Car tempCar2 = carHashMap.get(i+1);
                carHashMap.replace(i,tempCar2);
                carHashMap.replace(i+1,tempCar1);
//                carHashMap.set(i,tempCar2);
//                carHashMap.set(i+1,tempCar1);
            }
        }

        bubbleSort(carHashMap, n-1);           //one pass done, proceed to the next
    }
}
