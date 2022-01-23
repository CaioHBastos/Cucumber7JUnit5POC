package br.com.bts.poccucumber.dataprovider;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfiguration {

    @Value("${spring.datasource.url}")
    private String urlJdbc;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.jpa.properties.hibernate.dialect}")
    private String dialect;

    @Bean
    public DataSource dataSource() {
        final HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(urlJdbc);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
        hikariConfig.setMaximumPoolSize(5);
        hikariConfig.setMaxLifetime(600000);

        return new HikariDataSource(hikariConfig);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        final LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setDataSource(dataSource);
        entityManager.setPackagesToScan("br.com.bts.poccucumber.dataprovider.entities");
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        entityManager.setJpaProperties(additionalProperties());

        return entityManager;
    }

    @Bean
    public JpaTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);

        return transactionManager;
    }

    private Properties additionalProperties() {
        final Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "none");
        hibernateProperties.setProperty("hibernate.dialect", dialect);

        return hibernateProperties;
    }
}
