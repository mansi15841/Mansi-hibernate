package com.hbn.learning;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import com.hbn.configuration.HibernateConfiguration;
import com.hbn.entity.Address;
import com.hbn.entity.Employee;

import jakarta.persistence.NamedQuery;
import jakarta.persistence.Query;



public class Main {
	
	public static void saveRecord(Session session) {
		Transaction tx = session.beginTransaction();
		
		Employee e = new Employee();
		
		Address add = new Address();
		add.setCity("Noida");
		add.setState("UP");
		
		e.setName("Lakhan");
		e.setGender("male");
		e.setSalary(40000);
		e.setAddress(add);
		
		add.setEmployee(e);
		
//		session.persist(add);
		session.persist(e);
		
		tx.commit();
	}
	public static void main(String args[]) {
		
		Session session = HibernateConfiguration.getsessionFactory().openSession();
		
		saveRecord(session);
		
		Address address =  session.find(Address.class, 1);
		System.out.println(address);
		System.out.println(address.getEmployee());
//		
	}
}
