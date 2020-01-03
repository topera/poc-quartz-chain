package com.topera.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.topera.hello.model.Car;
import com.topera.hello.model.Customer;
import com.topera.hello.xmlbuilder.XMLBuilder;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JacksonTest {

    @Test
    public void test() throws JsonProcessingException {
        Customer customer = new Customer("Enzo");
        customer.addCar(new Car("ferrari"));
        customer.addCar(new Car("fiat"));

        String xml = "<Customer><name>Enzo</name><cars><cars><name>ferrari</name></cars><cars><name>fiat</name></cars></cars></Customer>";
        assertEquals(xml, XMLBuilder.build(customer));
    }

}