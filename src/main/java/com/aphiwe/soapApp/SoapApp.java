package com.aphiwe.soapApp;

import com.aphiwe.soapApp.services.StudentsServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.Endpoint;

public class SoapApp {
    private static final Logger logger = LoggerFactory.getLogger(SoapApp.class);

    public static void main(String[] args) {
        logger.info("Listening to http://localhost:8080/StudentsService?wsdl");
        Endpoint.publish(
                "http://localhost:8080/StudentsService",
                new StudentsServiceImp());

    }
}
