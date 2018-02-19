package com.suresh.app;

import com.suresh.Entitys.Customers;
import com.suresh.dao.Dao;
import com.suresh.dao.DaoImpl;
import com.suresh.exceptions.CustomException;

public class CustomerApp {

	public static void main(String[] args) throws CustomException {
		Dao customerDao = new DaoImpl();
		Customers customer = new Customers("john","smith","smith@gmail.com","Apple");
		customerDao.addCustomer(customer);
		
		Integer custId = customer.getCustIdPk();
		System.out.println("****************************");
		System.out.println(customer);
		System.out.println("****************************");
		System.out.println(customerDao.loadCustomer(custId));
		System.out.println("****************************");
		Customers customer1 = new Customers("will","walnut","willsmith@gmail.com","Amazon");
		customerDao.addCustomer(customer1);
		customer1.setLastName("terner");
		customerDao.updateCustomer(customer1);
		Integer custId1 = customer1.getCustIdPk();
		System.out.println("****************************");
		System.out.println(customerDao.loadCustomer(custId1));
		System.out.println("****************************");
		
		customerDao.deleteCustomer(custId);
		System.out.println("****************************");
		System.out.println(customerDao.loadCustomer(custId));
		System.out.println("****************************");
		//System.out.println("test 1\n"+customer+"\n"+customer1);
		
		
	}
}
