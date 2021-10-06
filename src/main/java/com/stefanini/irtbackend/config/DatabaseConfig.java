package com.stefanini.irtbackend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Driver;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@ComponentScan("com.stefanini.irtbackend")
public class DatabaseConfig {

    @Resource
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(env.getRequiredProperty("db.entity.package"));
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.setJpaProperties(getHibernateProperties());

        return em;
    }

    @Bean
    public PlatformTransactionManager platformTransactionManager() {
        JpaTransactionManager manager = new JpaTransactionManager();
        manager.setEntityManagerFactory(entityManagerFactory().getObject());

        return manager;
    }


    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource ds = new SimpleDriverDataSource();
        ds.setUrl(env.getRequiredProperty("db.url"));
        Class<Driver> driverClass = null;
        try {
            driverClass = (Class<Driver>) Class.forName("com.mysql.cj.jdbc.Driver");
            ds.setDriverClass(driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ds.setUsername(env.getRequiredProperty("db.username"));
        ds.setPassword(env.getRequiredProperty("db.password"));
        return ds;

    }

    public Properties getHibernateProperties() {
        try {
            Properties properties = new Properties();
            InputStream is = getClass().getClassLoader().getResourceAsStream("hibernate.properties");
            properties.load(is);

            return properties;
        } catch (IOException e) {
            throw new IllegalArgumentException("Can't find 'hibernate.properties' in classpath");
        }
    }
}
