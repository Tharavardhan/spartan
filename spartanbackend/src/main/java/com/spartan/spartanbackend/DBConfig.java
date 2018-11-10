package com.spartan.spartanbackend;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.spartan")
public class DBConfig {
	DataSource d;
	@Bean("mydatasource")
	DataSource getDataSource()
	{
		BasicDataSource b = new BasicDataSource();//DriverManagerDataSource can also be used
		b.setDriverClassName("org.h2.Driver");
		b.setUrl("jdbc:h2:tcp://localhost/~/test");
		b.setUsername("sa");
		b.setPassword("sa");
		return b;
	}
	
	//2.Language understood by database 
	@Bean("myproperties")
	Properties myDBProperties()
	{
		Properties properties = new Properties();//hashmap 
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");//CRUD --dml
		properties.setProperty("hibernate.hbm2ddl.auto", "update");//creating ur data struct
		properties.setProperty("hibernate.show_sql", "true");
		return properties;
	}
	
	//3.with the help of above config we will establish a connection
	@Autowired
	@Bean("sessionfactory")
	LocalSessionFactoryBean createsessionfactory(DataSource mydatasource,Properties myproperties)
	{      
		//orm to create queries
		LocalSessionFactoryBean  bean = new LocalSessionFactoryBean();
		bean.setDataSource(mydatasource);
		bean.setHibernateProperties(myproperties);
		bean.setPackagesToScan("com.spartan.spartanbackend.model");
		return bean;
	}
	
	@Autowired
	@Bean
	HibernateTransactionManager manger(SessionFactory sessionfactory)
	{
		HibernateTransactionManager htm=new HibernateTransactionManager();
		htm.setSessionFactory(sessionfactory);
		return htm;
	}

	
}
