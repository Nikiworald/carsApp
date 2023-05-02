package com.haemimont.carsapp.core.tools;

import com.haemimont.carsapp.core.generator.Generator;
import com.haemimont.carsapp.core.model.Car;

import java.util.*;

public class InputFromUser {
    public static Map<String, Integer> getInputs() {
        Map<String, Integer> inputMap = new HashMap<>();
        boolean validInput = false;
        while (!validInput) {
//            System.out.println("input:param,minYear,maxYear,Model,cnt");
            System.out.println("input:param,minYear,maxYear,cnt");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputValues = input.split(",");
//            if (inputValues.length == 5) {
            if (inputValues.length == 4) {
                try {
                    inputMap.put("param",Integer.parseInt(inputValues[0]));
                    inputMap.put("minYear",Integer.parseInt(inputValues[1]));
                    inputMap.put("maxYear",Integer.parseInt(inputValues[2]));
//                    inputMap.put("model", Integer.valueOf(inputValues[3]));
//                    inputMap.put("cnt",Integer.parseInt(inputValues[4]));
                    inputMap.put("cnt",Integer.parseInt(inputValues[3]));

                    validInput = true;

                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {
                System.out.println("Wrong number of parameters.Expected 5 provided " + inputValues.length + "\ntry again");
            }
        }
        return inputMap;
    }

}
