package com.aphiwe.soapApp;

import com.aphiwe.soapApp.services.StudentsServiceImp;
import com.aphiwe.soapApp.configs.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.Endpoint;

public class SoapApp {
    private static final Logger logger = LoggerFactory.getLogger(SoapApp.class);
    private static final Configuration config = new Configuration();

    public static void main(String[] args) {
        String url = config.host+":"+config.port+"/StudentsService";
        logger.info("Listening to "+url);
        Endpoint.publish(
                url,
                new StudentsServiceImp());

    }
}
