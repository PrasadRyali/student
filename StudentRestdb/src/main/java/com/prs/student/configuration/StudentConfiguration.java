package com.prs.student.configuration;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;



@Configuration
@ComponentScan(basePackages ="com.prs")
@PropertySource(value="classpath:application.properties")
public class StudentConfiguration {

	@Autowired
	Environment env;
	
	@Bean
	public DataSource GetDatasource(){
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setDriverClassName(env.getRequiredProperty("jdbc.driverClassname"));
		ds.setUrl(env.getRequiredProperty("jdbc.url"));
		ds.setUsername(env.getRequiredProperty("jdbc.username"));
		ds.setPassword(env.getRequiredProperty("jdbc.password"));
		return ds;
		}
	@Bean
	public JdbcTemplate GetJDBCTemplate(DataSource ds){
		return new JdbcTemplate(ds);
	}
}
