package com.haemimont.carsapp.core.model;

public class CarTypeB extends Car{

    public CarTypeB(String model, int year, double price) {
        super(model, year, price);
    }

    public double getPrice() {
        return super.getPrice()/2;
//    return 5;
    }
}
