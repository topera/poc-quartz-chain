package com.topera.hello.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("customer")
public class Customer {

    private String name;

    @JacksonXmlElementWrapper(localName = "cars")
    private List<Car> cars = new ArrayList<>();

    @SuppressWarnings("unused") // used by Jackson - on marshall
    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public void addCar(Car car) {
        this.cars.add(car);
    }

    public String getName() { // required by Jackson - on unmarshall
        return name;
    }

    @JsonProperty("car")
    public List<Car> getCars() { // used by Jackson - on unmarshall
        return cars;
    }

}
