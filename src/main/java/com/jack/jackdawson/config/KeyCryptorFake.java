package com.jack.jackdawson.config;

import org.springframework.core.io.ClassPathResource;
import java.util.Properties;

public class KeyCryptorFake extends KeyCryptor {

    private Properties props = new Properties();

    public KeyCryptorFake() {
        try {
            props.load(new ClassPathResource("config/db-fake.properties").getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String decrypt(String propertyName, String originValue) {
        return props.getProperty(propertyName);
    }

}
