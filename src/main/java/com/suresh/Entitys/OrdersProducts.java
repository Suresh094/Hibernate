package com.suresh.Entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

//@Data
@Entity
@Table(name = "orders_products")
public class OrdersProducts implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Order_product_Id")
	private Integer orderProductIdPk;

	private Integer quantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id_pk")
	private Orders orders;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Products  products;

	
	
	public OrdersProducts(int orderProductIdPk, int quantity) {
		super();
		this.orderProductIdPk = orderProductIdPk;
		this.quantity = quantity;

	}

	public OrdersProducts() {
		super();
	}

	public Integer getOrderProductIdPk() {
		return orderProductIdPk;
	}

	public void setOrderProductIdPk(Integer orderProductIdPk) {
		this.orderProductIdPk = orderProductIdPk;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrdersProducts [orderProductIdPk=");
		builder.append(orderProductIdPk);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", orders=");
		builder.append(", products=");
		builder.append(products);
		builder.append("]");
		return builder.toString();
	}
	
	

}

/*
 * @Id // @GeneratedValue(generator = "gen")
 * 
 * @GenericGenerator(name = "gen", strategy = "foreign", parameters
 * = @Parameter(name = "property", value = "Orders ")) private int orderIdFk;
 * 
 * @Id
 * 
 * @Column(name = "product_Id_Fk") // @GeneratedValue(generator = "gen")
 * 
 * @GenericGenerator(name = "gen", strategy = "foreign", parameters
 * = @Parameter(name = "property", value = "Products")) private int productIdFk;
 */
/*
 * @ManyToOne
 * 
 * @PrimaryKeyJoinColumn private Orders orders;
 * 
 * @ManyToOne
 * 
 * @PrimaryKeyJoinColumn private Products products;
 */