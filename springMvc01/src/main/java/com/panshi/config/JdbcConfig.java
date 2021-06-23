/*
package com.panshi.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.beans.PropertyVetoException;


public class JdbcConfig {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user_name}")
    private String user_name;
    @Value("${pwd}")
    private String pwd;

    @Bean("dataSource")
    public ComboPooledDataSource createComboPooledDataSource() {
        ComboPooledDataSource cpd = new ComboPooledDataSource();
        try {
            cpd.setDriverClass(driver);
            cpd.setJdbcUrl(url);
            cpd.setUser(user_name);
            cpd.setPassword(pwd);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return cpd;
    }

}
*/
