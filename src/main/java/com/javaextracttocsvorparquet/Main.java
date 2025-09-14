package com.javaextracttocsvorparquet;

import com.javaextracttocsvorparquet.manager.CarManager;
import com.javaextracttocsvorparquet.manager.ParquetManager;
import com.javaextracttocsvorparquet.models.Cars;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws Exception {
        ArrayList<Cars> cars = CarManager.getCarList();
        for (Cars car : cars) {
            System.out.println(car);
        }
        try {
            ParquetManager.writeListToParquet(cars, "src/main/java/com/javaextracttocsvorparquet/fileStore");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}