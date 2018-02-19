package com.suresh.Entitys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name = "Orders")
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

	@Column(name = "invoice_creation_date")
	private Date invoiceCreationDate;

	@Column(name = "delivery_due_date")
	private Date deliveryDueDate;

	@Column(name = "payment_due_date")
	private Date paymentDueDate;

	@Column(name = "custom_message")
	private String customMessage;

	@ManyToOne
	// @PrimaryKeyJoinColumn
	@JoinColumn(name = "customer_id")
	private Customers customer;

	@OneToMany
	@JoinColumn(name = "order_id_pk")
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

}
