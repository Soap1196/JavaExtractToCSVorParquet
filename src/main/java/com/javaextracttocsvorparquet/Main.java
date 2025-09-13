package com.javaextracttocsvorparquet;

import java.util.ArrayList;

import com.javadataframe.models.Cars;

import main.java.com.javaextracttocsvorparquet.manager.CarManager;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Cars> cars = CarManager.getCarList();
        
    }
}