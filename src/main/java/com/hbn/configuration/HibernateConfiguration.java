package com.hbn.configuration;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateConfiguration {
		public static SessionFactory getsessionFactory() {
			StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("cfg.xml").build();
			
			Metadata metadata = new MetadataSources(ssr).getMetadataBuilder().build();
			
			return metadata.buildSessionFactory();
			
			
		}
}
