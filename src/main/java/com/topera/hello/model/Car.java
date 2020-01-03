package com.topera.hello.model;

public class Car {

    private String name;

    public Car(String name) {
        this.name = name;
    }

    @SuppressWarnings("unused") // used by Jackson
    public String getName() {
        return name;
    }

}
