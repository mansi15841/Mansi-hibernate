package com.hbn.learning;

import java.util.ArrayList;
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
		
		Address add1 = new Address();
		add1.setCity("Noida");
		add1.setState("UP");
		
		Address add2 = new Address();
		add2.setCity("Panipat");
		add2.setState("Haryana");
		
		Address add3 = new Address();
		add3.setCity("GZB");
		add3.setState("UP");
		
		ArrayList<Address> listofAddress = new ArrayList<>();
		listofAddress.add(add1);
		listofAddress.add(add2);
		listofAddress.add(add3);
		
		
		e.setName("Lakhan");
		e.setGender("male");
		e.setSalary(40000);
		e.setAddress(listofAddress);
		
		session.persist(add1);
		session.persist(add2);
		session.persist(add3);
		session.persist(e);
		
		tx.commit();
	}
	public static void main(String args[]) {
		
		Session session = HibernateConfiguration.getsessionFactory().openSession();
		
//		saveRecord(session);
		Employee employee = session.find(Employee.class, 1);
		System.out.println(employee);
	}
}
