package ru.simpleCRUD.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.PropertyResolver;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:conf.properties")
@EnableTransactionManagement
@ComponentScan(basePackages = "ru.simpleCRUD")
public class AppContext {
    private PropertyResolver propertyResolver;

    @Autowired
    public void setEnvironment(PropertyResolver propertyResolver) {
        this.propertyResolver = propertyResolver;
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", propertyResolver.getRequiredProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", propertyResolver.getRequiredProperty("hibernate.show_sql"));
        properties.put("hibernate.hbm2ddl.auto", propertyResolver.getRequiredProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(propertyResolver.getRequiredProperty("hibernate.connection.driver_class"));
        dataSource.setUrl(propertyResolver.getRequiredProperty("hibernate.connection.url"));
        dataSource.setUsername(propertyResolver.getRequiredProperty("hibernate.connection.username"));
        dataSource.setPassword(propertyResolver.getRequiredProperty("hibernate.connection.password"));
        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.simpleCRUD.models");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
