package com.hc.commonsearch.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class JasyptConfigTest {

    @Autowired
    JasyptConfig jasyptConfig;

    @Test
    void testEncrypt(){
        String str="password";
        String encrypt_Password=jasyptConfig.jasyptStringEncryptor().encrypt(str);
        System.out.println("encrypt_Password =>"+encrypt_Password);
        assertThat(encrypt_Password).isNotEqualTo(str);
    }

    @Test
    void testDecrypt(){
        String str="password";
        String encryptPassword=jasyptConfig.jasyptStringEncryptor().encrypt(str);
        String decryptPassword=jasyptConfig.jasyptStringEncryptor().decrypt(encryptPassword);
        assertThat(decryptPassword).isEqualTo(str);
    }

}