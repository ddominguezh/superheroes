package com.ddominguezh.superhero.shared.infrastructure.repository;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ddominguezh.superhero.shared.infrastructure.config.Parameter;
import com.ddominguezh.superhero.shared.infrastructure.config.ParameterNotExist;
import com.ddominguezh.superhero.shared.infrastructure.hibernate.HibernateConfigurationFactory;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	private final HibernateConfigurationFactory factory;
    private final Parameter config;
    private final String CONTEXT_NAME = "app";

    public HibernateConfiguration(HibernateConfigurationFactory factory, Parameter config) {
        this.factory = factory;
        this.config  = config;
        this.config.load("hibernate.properties");
    }

    @Bean("transaction_manager")
    public PlatformTransactionManager hibernateTransactionManager() throws IOException, ParameterNotExist {
        return factory.hibernateTransactionManager(sessionFactory());
    }

    @Bean("session_factory")
    public LocalSessionFactoryBean sessionFactory() throws IOException, ParameterNotExist {
        return factory.sessionFactory(CONTEXT_NAME, dataSource());
    }

    @Bean("data_source")
    public DataSource dataSource() throws IOException, ParameterNotExist {
        return factory.dataSource(
            config.get("BACKOFFICE_DATABASE_NAME"),
            config.get("BACKOFFICE_DATABASE_USER"),
            config.get("BACKOFFICE_DATABASE_PASSWORD")
        );
    }
    
}
