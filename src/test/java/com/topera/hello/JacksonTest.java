package com.topera.hello;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.topera.hello.model.Car;
import com.topera.hello.model.Customer;
import com.topera.hello.xmlbuilder.XMLBuilder;
import com.topera.hello.xmlparser.XMLParser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JacksonTest {

    private static final String RAW_XML = "" +
            "<customer>" +
            "    <name>Enzo</name>" +
            "    <cars>" +
            "        <car>" +
            "            <name>ferrari</name>" +
            "        </car>" +
            "        <car>" +
            "            <name>fiat</name>" +
            "        </car>" +
            "    </cars>" +
            "</customer>";

    private static final String XML = RAW_XML.replaceAll("\\s", "");

    @Test
    public void test() throws JsonProcessingException {
        Customer customer = new Customer("Enzo");
        customer.addCar(new Car("ferrari"));
        customer.addCar(new Car("fiat"));

        assertEquals(XML, XMLBuilder.build(customer));
    }

    @Test
    public void testUnmarshall() throws JsonProcessingException {
        Customer customer = XMLParser.parse(XML);

        assertEquals("Enzo", customer.getName());
        assertEquals("ferrari", customer.getCars().get(0).getName());
        assertEquals("fiat", customer.getCars().get(1).getName());
    }

    @Test
    public void testComplete() throws JsonProcessingException {
        assertEquals(XML, XMLBuilder.build(XMLParser.parse(XML)));
    }

}