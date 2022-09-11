package com.aphiwe.soapApp.configs;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class Configuration {
    public Configuration(){}
    private Config config = ConfigFactory
            .parseResourcesAnySyntax("application.conf")
            .withFallback(ConfigFactory.load())
            .resolve();
    public String dbDriverClass = config.getString("db.driverClass");
    public String dbUrl = config.getString("db.url");
    public String dbUser = config.getString("db.user");
    public String dbPassword = config.getString("db.password");
    public int port = config.getInt("http.port");
    public String host = config.getString("http.host");

}
