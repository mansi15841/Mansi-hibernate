package com.hbn.learning;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hbn.configuration.HibernateConfiguration;
import com.hbn.entity.Employee;


public class Main {
	public static void main(String args[]) {
		
		Employee employee = new Employee("Saloni","female",10000);
		
		Session session = HibernateConfiguration.getsessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.persist(employee);
		
		tx.commit();
		
	}
}
