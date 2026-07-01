package com.hbn.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;



public class HibernateConfiguration {
		public static SessionFactory getsessionFactory() {
			
			Properties properties = new Properties();
			
			properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			properties.put(Environment.JAKARTA_JDBC_URL,"jdbc:mysql://localhost:3306/hibernate_example");
			properties.put(Environment.JAKARTA_JDBC_USER, "root");
			properties.put(Environment.JAKARTA_JDBC_PASSWORD, "root");
			properties.put(Environment.HBM2DDL_AUTO,"update");
			properties.put(Environment.SHOW_SQL,"true");
			properties.put(Environment.FORMAT_SQL,"true");
			
			
			
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().applySettings(properties).build();
			
			Metadata metadata = new MetadataSources(ssr).addAnnotatedClasses(com.hbn.entity.Employee.class,com.hbn.entity.Project.class).getMetadataBuilder().build();
			
			return metadata.buildSessionFactory();
			
		}
}
