package com.haemimont.carsapp.core.model;

public class CarTypeA extends Car{
    public CarTypeA(String model, int year, double price) {
        super(model, year, price);
    }
    @Override
    public double getPrice(){
        return price;
    }
}
