package com.topera.hello.xmlbuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.topera.hello.model.Customer;

public class XMLBuilder {

    public static String build(Customer customer) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(customer);
    }

}
