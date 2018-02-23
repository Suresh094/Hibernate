package com.suresh.Entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@SuppressWarnings("serial")
//@Data
@Entity
@Table(name = "orders")
public class Orders implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id_pk")
	private Integer orderIdPk;
	/*
	 * @Id
	 * 
	 * @Column(name = "cust_id_Fk")
	 * 
	 * @GenericGenerator(name = "gen", strategy = "foreign", parameters
	 * =@Parameter(name = "property", value = "customer")) private int custIdFk;
	 */
	
	@Basic
	@Temporal(TemporalType.DATE)
	@Column(name = "invoice_creation_date")
	private Date invoiceCreationDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "delivery_due_date")
	private Date deliveryDueDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "payment_due_date")
	private Date paymentDueDate;

	@Column(name = "custom_message")
	private String customMessage;
	
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="total_order_price")
	private Double totalOrderPrice;

	/*@ManyToOne
	// @PrimaryKeyJoinColumn
	@JoinColumn(name = "customer_id")
	private Customers customer;*/

	@OneToMany(mappedBy = "orders",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrdersProducts> ordersProducts;

	public Orders(Integer orderIdPk, Date invoiceCreationDate, Date deliveryDueDate, Date paymentDueDate,
			String customMessage) {
		super();
		this.orderIdPk = orderIdPk;
		this.invoiceCreationDate = invoiceCreationDate;
		this.deliveryDueDate = deliveryDueDate;
		this.paymentDueDate = paymentDueDate;
		this.customMessage = customMessage;
	}

	public Orders() {
		super();
	}

	public Integer getOrderIdPk() {
		return orderIdPk;
	}
	
	public void setOrderIdPk(Integer orderIdPk) {
		this.orderIdPk = orderIdPk;
	}
	
	public Date getInvoiceCreationDate() {
		return invoiceCreationDate;
	}
	
	public void setInvoiceCreationDate(Date invoiceCreationDate) {
		this.invoiceCreationDate = invoiceCreationDate;
	}
	
	public Date getDeliveryDueDate() {
		return deliveryDueDate;
	}
	
	public void setDeliveryDueDate(Date deliveryDueDate) {
		this.deliveryDueDate = deliveryDueDate;
	}
	
	public Date getPaymentDueDate() {
		return paymentDueDate;
	}
	
	public void setPaymentDueDate(Date paymentDueDate) {
		this.paymentDueDate = paymentDueDate;
	}
	
	public String getCustomMessage() {
		return customMessage;
	}
	
	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
	
	public String getOrderStatus() {
		return orderStatus;
	}
	
	public void setOrderStatus() {
		if(deliveryDueDate.compareTo(new Date())>0){
			this.orderStatus="processing";
		}
		else if(deliveryDueDate.compareTo(new Date())<0){
			this.orderStatus="delivered";
		}
		else{
			this.orderStatus="Delivering Today";
		}
	}
	
	public Double getTotalOrderPrice() {
		return totalOrderPrice;
	}
	
	public void setTotalOrderPrice(Double totalOrderPrice) {
		this.totalOrderPrice = totalOrderPrice;
	}
	
	public List<OrdersProducts> getOrdersProducts() {
		return ordersProducts;
	}
	
	public void setOrdersProducts(List<OrdersProducts> ordersProducts) {
		this.ordersProducts = ordersProducts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orders [orderIdPk=");
		builder.append(orderIdPk);
		builder.append(", invoiceCreationDate=");
		builder.append(invoiceCreationDate);
		builder.append(", deliveryDueDate=");
		builder.append(deliveryDueDate);
		builder.append(", paymentDueDate=");
		builder.append(paymentDueDate);
		builder.append(", customMessage=");
		builder.append(customMessage);
		builder.append(", orderStatus=");
		builder.append(orderStatus);
		builder.append(", totalOrderPrice=");
		builder.append(totalOrderPrice);
		builder.append(", ordersProducts=");
		builder.append(ordersProducts);
		builder.append("]");
		return builder.toString();
	}
	
	
}
