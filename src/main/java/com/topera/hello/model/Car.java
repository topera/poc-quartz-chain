package com.topera.hello.model;

public class Car {

    private String name;

    @SuppressWarnings("unused") // used by Jackson - on marshall
    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() { // used by Jackson - on unmarshall
        return name;
    }

}
