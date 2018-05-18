package com.innoviti.quickemitab.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.innoviti.quickemitab.repository.config"},
					   entityManagerFactoryRef = "entityConfigManagerFactory",
					   transactionManagerRef = "configManager")
public class DataSourceConfiguration {
	
  @Autowired
  private Environment env;

  @Primary
  @Bean(name="configDataSource",destroyMethod = "close")
  public DataSource configDataSource() {
    HikariConfig dataSourceConfig = new HikariConfig();
    dataSourceConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.driver"));
    dataSourceConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.config.url"));
    dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.config.username"));
    dataSourceConfig.setPassword(env.getRequiredProperty("spring.datasource.config.password"));
    dataSourceConfig.setAutoCommit(false);
    String maxPoolSize = env.getRequiredProperty("spring.datasource.max.poolsize");
    String minIdle = env.getRequiredProperty("spring.datasource.min.idle");
    dataSourceConfig.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
    dataSourceConfig.setMinimumIdle(Integer.parseInt(minIdle));
    return new HikariDataSource(dataSourceConfig);
  }
  
  @Primary
  @Bean(name="entityConfigManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityConfigManagerFactory(@Qualifier("configDataSource") DataSource dataSource) {
    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
    entityManagerFactoryBean.setDataSource(dataSource);
    entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    entityManagerFactoryBean.setPackagesToScan(new String[]{"com.innoviti.quickemitab.dao.model"});
    entityManagerFactoryBean.setPersistenceUnitName("entityConfigManagerFactory");

    Properties jpaProperties = new Properties();
    jpaProperties.put("hibernate.dialect", env.getRequiredProperty("hibernate.dialect"));
    jpaProperties.put("hibernate.hbm2ddl.auto", env.getRequiredProperty("hibernate.hbm2ddl.auto"));
    jpaProperties.put("hibernate.ejb.naming_strategy", env.getRequiredProperty("hibernate.ejb.naming_strategy"));
    jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("hibernate.show_sql"));
    jpaProperties.put("hibernate.format_sql", env.getRequiredProperty("hibernate.format_sql"));

    entityManagerFactoryBean.setJpaProperties(jpaProperties);
    return entityManagerFactoryBean;
  }
  
  
  @Primary
  @Bean(name = "configManager")
  public PlatformTransactionManager configManager(@Qualifier("entityConfigManagerFactory") EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }
  
  @Bean
  public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    return new MappingJackson2HttpMessageConverter(mapper);
  }
}
