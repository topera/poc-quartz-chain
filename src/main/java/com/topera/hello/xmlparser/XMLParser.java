package com.topera.hello.xmlparser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.topera.hello.model.Customer;

public class XMLParser {

    public static Customer parse(String xml) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(xml, Customer.class);
    }

}
