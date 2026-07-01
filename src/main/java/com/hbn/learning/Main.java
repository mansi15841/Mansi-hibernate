package com.hbn.learning;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hbn.configuration.HibernateConfiguration;
import com.hbn.entity.Employee;
import com.hbn.entity.Project;



public class Main {
	
	public static void saveRecord(Session session) {
		Transaction tx = session.beginTransaction();
		
		Project pro1 = new Project();
		pro1.setProj_name("Banking System");
		
		Project pro2 = new Project();
		pro2.setProj_name("Music Composer");
		
		Project pro3 = new Project();
		pro3.setProj_name("AI System");
		
		
		Employee employee = new Employee();
		employee.setName("Mansi");
		employee.setSalary(50000);
		employee.setGender("female");
		
		Employee employee1 = new Employee();
		employee1.setName("Krishan");
		employee1.setSalary(40000);
		employee1.setGender("male");
		
		Employee employee3 = new Employee();
		employee3.setName("Rahul");
		employee3.setSalary(40000);
		employee3.setGender("male");
		
		employee.setProject(Arrays.asList(pro1,pro2));
		employee1.setProject(Arrays.asList(pro2,pro3));
		employee3.setProject(Arrays.asList(pro1,pro3));
		
		pro1.setEmployee(Arrays.asList(employee,employee3));
		pro2.setEmployee(Arrays.asList(employee,employee1));
		pro3.setEmployee(Arrays.asList(employee1,employee3));
		
		session.persist(employee);
		session.persist(employee1);
		session.persist(employee3);
		
		tx.commit();
	}
	public static void main(String args[]) {
		
		Session session = HibernateConfiguration.getsessionFactory().openSession();
		
		//saveRecord(session);
		
		Project project = session.find(Project.class, 2);
		System.out.println(project);
		System.out.println(project.getEmployee());
		
		
	}
}
