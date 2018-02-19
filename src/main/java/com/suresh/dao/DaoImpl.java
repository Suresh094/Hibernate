package com.suresh.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.suresh.Entitys.Customers;
import com.suresh.exceptions.CustomException;
import com.suresh.util.HibernateUtils;

public class DaoImpl implements Dao {
	
	public void addCustomer(Customers customers) throws CustomException {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(customers);
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
		} finally {
			if (session != null) session.close();	
		}
	}

	public Customers loadCustomer(Integer stdId) throws CustomException {
		Session session = getSession();
		Customers student = (Customers) session.get(Customers.class, stdId);
		session.close();
		return student;
	}

	public void updateCustomer(Customers std) throws CustomException {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.update(std);
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
		} finally {
			if (session != null) session.close();	
		}
	}

	public void deleteCustomer(Integer stdId) throws CustomException {
		Session session = getSession();
		Transaction transaction = session.beginTransaction();
		try {
			Customers student = (Customers) session.get(Customers.class, stdId.intValue());
			session.delete(student);
			transaction.commit();
		} catch(Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			if (session != null) session.close();	
		}
		
	}

	private Session getSession() {
		return HibernateUtils.getSessionFactory().openSession();
	}

	

}
