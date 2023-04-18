package com.haemimont.carsapp.core.main;

import com.haemimont.carsapp.core.generator.Generator;
import com.haemimont.carsapp.core.model.Car;
import com.haemimont.carsapp.core.model.CarTypeB;
import com.haemimont.carsapp.core.tools.CarMakeModel;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean validInput = false;
//        CarTypeB carTypeB = new CarTypeB("asda",123,123);
//        System.out.println(carTypeB.getClass().getName().contains("TypeB"));
//        HashMap<Integer,Car> hashMap = Generator.generateRandomCars(1999,2010, CarMakeModel.getMakes(),10);
        HashMap<Integer,Car> hashMap = null;
        while(!validInput) {
            System.out.println("input:param,minYear,maxYear,Model,cnt");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputValues = input.split(",");
            if(inputValues.length==5){
                try{
                    int param = Integer.parseInt(inputValues[0]);
                    int minYear = Integer.parseInt(inputValues[1]);
                    int maxYear = Integer.parseInt(inputValues[2]);
                    String model = inputValues[3];
                    int cnt = Integer.parseInt(inputValues[4]);
                    
                    hashMap = Generator.generateRandomCars(minYear,maxYear,model,cnt);
                    validInput=true;
                }catch (Exception e){
                    System.out.println(e);
                }
                
            }else {
                System.out.println("Wrong number of parameters.Expected 5 provided "+inputValues.length+"\ntry again");
            }

        }
        System.out.println(hashMap.toString());
        hashMap.forEach((key,value)->{
            System.out.println(value.getPrice());
        });


    }
}
