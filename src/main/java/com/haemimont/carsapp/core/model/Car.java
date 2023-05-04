package com.haemimont.carsapp.core.model;

public class Car {
    protected String model;
    protected int year;
    protected double price;

    public Car(String model, int year, double price) {
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
