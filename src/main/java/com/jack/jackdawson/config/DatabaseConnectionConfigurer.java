package com.jack.jackdawson.config;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import java.util.Enumeration;
import java.util.Properties;

public class DatabaseConnectionConfigurer extends PropertyPlaceholderConfigurer {
    private Properties properties;

    private KeyCryptor keyCryptor;

    public DatabaseConnectionConfigurer() {
    }

    public void setKeyCryptor(KeyCryptor keyCryptor) {
        this.keyCryptor = keyCryptor;
    }

    @Override
    protected void convertProperties(Properties props) {
        Enumeration propertyNames = props.propertyNames();

        while (propertyNames.hasMoreElements()) {
            String propertyName = (String) propertyNames.nextElement();
            String propertyValue = props.getProperty(propertyName);
            String convertedValue = this.convertPropertyValue(propertyValue);

            props.setProperty(propertyName, convertedValue);

        }

        this.properties = props;
    }

    @Override
    protected String convertProperty(String propertyName, String originValue) {
        //可以在这里进行一些加解密操作
        return this.keyCryptor.decrypt(propertyName, originValue);
    }

    @Override
    protected String convertPropertyValue(String originValue) {
        return originValue;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }

}
