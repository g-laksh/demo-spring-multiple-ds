package com.java.multiple.ds.api.config;

import java.util.HashMap;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
@PropertySource({"classpath:application.properties"})
@EnableJpaRepositories(entityManagerFactoryRef = "mainentityManager", 
          basePackages =
		"com.java.multiple.ds.api.user.repository" ,  transactionManagerRef="usertransactionManager")
public class UserDBConfig {
	
	@Autowired
    private Environment env;
	
	@Primary
	@Bean
	@ConfigurationProperties(prefix = "spring.user.datasource")
	public DataSource userdataSource() {
		
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean mainentityManager() {
		 LocalContainerEntityManagerFactoryBean em
         = new LocalContainerEntityManagerFactoryBean();
       em.setDataSource(userdataSource());
       em.setPackagesToScan(
         new String[] { "com.java.multiple.ds.api.model.user"});
		
       HibernateJpaVendorAdapter vendorAdapter
       = new HibernateJpaVendorAdapter();
     em.setJpaVendorAdapter(vendorAdapter);
		HashMap<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto",
		          env.getProperty("spring.jpa.hibernate.ddl-auto"));
		        properties.put("hibernate.dialect",
		          env.getProperty("hibernate.dialect"));
		        em.setJpaPropertyMap(properties);
		        
		return em;
	}

	@Primary
	@Bean
	public PlatformTransactionManager usertransactionManager() {
		
		JpaTransactionManager transactionManager
        = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(
    		  mainentityManager().getObject());
      return transactionManager;
	}
}