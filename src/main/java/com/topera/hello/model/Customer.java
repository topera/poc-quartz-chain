package com.topera.hello.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Car> cars = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    @SuppressWarnings("unused") // used by Jackson
    public String getName() {
        return name;
    }

    @SuppressWarnings("unused") // used by Jackson
    public List<Car> getCars() {
        return cars;
    }

}
