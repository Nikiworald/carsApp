package com.haemimont.carsapp.core.tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class CarMakeModel {
    static File file = new File("src/main/java/com/haemimont/carsapp/core/tools/makemodels");
    static String allLines;
    static String[] values;

    static {
        loadFileAndReturnValues();
    }

    private static void loadFileAndReturnValues() {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                allLines = scanner.nextLine();
            }
            values = allLines.split(",");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] getMakes() {
        return values;
    }

//    public static String getRandomMake() {
//        String make;
//        Random random = new Random();
//        int randomInt = random.nextInt(values.length);
//        make = values[randomInt];
//        return make;
//    }

}
