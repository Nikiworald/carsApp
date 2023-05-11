package com.haemimont.carsapp.core.utils;

import com.haemimont.carsapp.core.model.Car;

import java.util.HashMap;
import java.util.List;

public class FromListToHashMapWithNoKey{
    public static HashMap<Integer, Car> convert(List<Car> list) {
        HashMap<Integer,Car> hashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            hashMap.put(i,list.get(i));
        }
        return hashMap;
    }


}
