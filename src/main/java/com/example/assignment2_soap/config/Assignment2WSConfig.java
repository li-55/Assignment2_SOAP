package com.example.assignment2_soap.config;

import com.example.assignment2_soap.Assignment2SoapWS;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class Assignment2WSConfig {

    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {

        Endpoint endpoint = new EndpointImpl(bus, new Assignment2SoapWS());
        endpoint.publish("/soap-assignment");

    return endpoint;}
}
