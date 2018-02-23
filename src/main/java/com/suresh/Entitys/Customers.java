package com.suresh.Entitys;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "customer", uniqueConstraints = { @UniqueConstraint(columnNames = "first_name"),
		@UniqueConstraint(columnNames = "last_name") })

// @Data
@Access(AccessType.FIELD)
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private Integer custIdPk;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	private String Company;

	@Column(name = "billing_street")
	private String billingStreet;

	@Column(name = "billing_city")
	private String billingCity;

	@Column(name = "billing_state")
	private String billingState;

	@Column(name = "billing_zip")
	private Integer billingZip;

	@Column(name = "billing_country")
	private String billingCountry;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private List<Orders> orders;

	@OneToOne( fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setCustIdPk(Integer custIdPk) {
		this.custIdPk = custIdPk;
	}

	public void setBillingZip(Integer billingZip) {
		this.billingZip = billingZip;
	}

	public int getCustIdPk() {
		return custIdPk;
	}

	public void setCustIdPk(int custIdPk) {
		this.custIdPk = custIdPk;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}

	public String getBillingStreet() {
		return billingStreet;
	}

	public void setBillingStreet(String billingStreet) {
		this.billingStreet = billingStreet;
	}

	public String getBillingCity() {
		return billingCity;
	}

	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	public String getBillingState() {
		return billingState;
	}

	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}

	public int getBillingZip() {
		return billingZip;
	}

	public void setBillingZip(int billingZip) {
		this.billingZip = billingZip;
	}

	public String getBillingCountry() {
		return billingCountry;
	}

	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customers [custIdPk=");
		builder.append(custIdPk);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", Company=");
		builder.append(Company);
		builder.append(", billingStreet=");
		builder.append(billingStreet);
		builder.append(", billingCity=");
		builder.append(billingCity);
		builder.append(", billingState=");
		builder.append(billingState);
		builder.append(", billingZip=");
		builder.append(billingZip);
		builder.append(", billingCountry=");
		builder.append(billingCountry);
		builder.append(", orders=");
		builder.append(orders);
		builder.append("]");
		return builder.toString();
	}

	public Customers(Integer custIdPk, String firstName, String lastName, String email, String company,
			String billingStreet, String billingCity, String billingState, Integer billingZip, String billingCountry,
			List<Orders> orders) {
		super();
		this.custIdPk = custIdPk;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Company = company;
		this.billingStreet = billingStreet;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
		this.billingCountry = billingCountry;
		this.orders = orders;
	}

	public Customers(String firstName, String lastName, String email, String company) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		Company = company;
	}

	public Customers() {
		super();
	}
	
	

}
