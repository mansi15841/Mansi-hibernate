package com.hbn.learning;

import java.util.List;
import java.util.function.ToDoubleBiFunction;



import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.MutationQuery;

import com.hbn.configuration.HibernateConfiguration;
import com.hbn.entity.Employee;

import jakarta.persistence.Query;



public class Main {
	public static void main(String args[]) {
		
		Session session = HibernateConfiguration.getsessionFactory().openSession();
		
		Transaction tx = session.beginTransaction();
		
//		To get Record from db
//		Employee employee = session.find(Employee.class,7);
//		System.out.println(employee);
		
//		to get all record from db
//		Query query = session.createQuery("from Employee",Employee.class);
//		List list = query.getResultList();
//		System.out.println(list);
		
//		to get Record with pagination
//		Query query = session.createQuery("from Employee",Employee.class);
//		query.setFirstResult(2);
//		query.setMaxResults(1);
//		List list = query.getResultList();
//		System.out.println(list);
		
//	    to update record in db	
//		MutationQuery query = session.createMutationQuery("update Employee set name=:n where id=:i");
//		query.setParameter("n", "updated_name");
//		query.setParameter("i", 5);
//		query.executeUpdate();
		
//		to delete record from db
//		MutationQuery query = session.createMutationQuery("Delete from Employee where id=:i");
//		query.setParameter("i", 7);
//		query.executeUpdate();
		
//		Aggregate function sum()
//		Query query = session.createQuery("select sum(salary) from Employee");
//		List list = query.getResultList();
//		System.out.println(list);
		
//		Max()
//		Query query = session.createQuery("select max(salary) from Employee");
//		List list = query.getResultList();
//		System.out.println(list);
		
//		min()
//		Query query = session.createQuery("select min(salary) from Employee");
//		List list = query.getResultList();
//		System.out.println(list);
		
//		count()
//		Query query = session.createQuery("select count(salary) from Employee");
//		List list = query.getResultList();
//		System.out.println(list);
		
//		avg()
		Query query = session.createQuery("select avg(salary) from Employee");
		List list = query.getResultList();
		System.out.println(list);
		
		tx.commit();
		
	}
}
