package com.hbn.learning;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import com.hbn.configuration.HibernateConfiguration;
import com.hbn.entity.Employee;

import jakarta.persistence.NamedQuery;
import jakarta.persistence.Query;



public class Main {
	public static void main(String args[]) {
		
		Session session = HibernateConfiguration.getsessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
		Query query = session.createNamedQuery("EmpByName");
		query.setParameter("name","riya");
		List list = query.getResultList();
		System.out.println(list);
		
		Query query2 = session.createNamedQuery("findById");
		query2.setParameter("id",5);
		List list2 = query2.getResultList();
		System.out.println(list2);
		
		Query query3 = session.createNamedQuery("deleteById");
		query3.setParameter("id",8);
		query3.executeUpdate();
		
		tx.commit();
		
	}
}
