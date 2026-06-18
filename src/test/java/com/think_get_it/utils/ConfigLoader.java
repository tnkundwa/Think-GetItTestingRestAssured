package com.think_get_it.utils;

import java.util.Properties;

public class ConfigLoader {
    private static ConfigLoader configLoader;
    private final Properties properties;

    private ConfigLoader() {
        properties = PropertyUtils.propertyLoader("src/test/resources/config.properties");
    }

    public static ConfigLoader getInstance() {
        if (configLoader == null) {
            configLoader = new ConfigLoader();
        }
        return configLoader;
    }

    public String getAccessTokenAdmin() {
        String prop = properties.getProperty("access_token_admin");
        if (prop != null) return prop;
        else throw new RuntimeException("property access_token_admin is not specified in the config.properties file");
    }

    public String getUserEmail() {
        String prop = properties.getProperty("user_email");
        if (prop != null) return prop;
        else throw new RuntimeException("property user_email is not specified in the config.properties file");
    }

    public String getAdminEmail() {
        String prop = properties.getProperty("admin_email");
        if (prop != null) return prop;
        else throw new RuntimeException("property admin_email is not specified in the config.properties file");
    }

    public String getPassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        else throw new RuntimeException("property password is not specified in the config.properties file");
    }

    public String getAccessTokenUser() {
        String prop = properties.getProperty("access_token_user");
        if (prop != null) return prop;
        else throw new RuntimeException("property access_token_user is not specified in the config.properties file");
    }
}
