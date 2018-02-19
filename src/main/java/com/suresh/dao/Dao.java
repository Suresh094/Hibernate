package com.suresh.dao;

import com.suresh.Entitys.Customers;

import com.suresh.exceptions.*;

public interface Dao {
	public void addCustomer(Customers customer) throws CustomException;

	public Customers loadCustomer(Integer custId) throws CustomException;

	public void updateCustomer(Customers customer) throws CustomException;

	public void deleteCustomer(Integer custId) throws CustomException;
}
