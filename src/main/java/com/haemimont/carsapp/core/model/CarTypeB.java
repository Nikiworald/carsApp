package com.haemimont.carsapp.core.model;

public class CarTypeB extends Car{
    public CarTypeB(String model, int year, double price) {
        super(model, year, price);
    }
    @Override
    public double getPrice(){
        return price/2;
    }
}
