package com.springboot.demo.configuration;

import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataConfiguration {

    @Bean
    public DataSource dataSource(DbConnProperties properties) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        return dataSource;
    }

    @Bean
    public MetadataSources getMetaSource(DbConnProperties properties) {
        Map<String, String> settings = new HashMap<>();
        settings.put("connection.driver_class", properties.getDriverClassName());
        settings.put("dialect", properties.getDialect());
        settings.put("hibernate.connection.url", properties.getUrl());
        settings.put("hibernate.connection.username", properties.getUsername());
        settings.put("hibernate.connection.password", properties.getPassword());
        settings.put("hibernate.current_session_context_class", properties.getCurrentSessionContextClass());
        settings.put("hibernate.show_sql", properties.getShowSql());
        settings.put("hibernate.format_sql", properties.getFormatSql());

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(settings).build();

        return new MetadataSources(serviceRegistry);
    }
}
