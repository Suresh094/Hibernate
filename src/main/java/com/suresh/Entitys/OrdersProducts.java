package com.suresh.Entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Orders_Products")
public class OrdersProducts implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Order_product_Id")
	private Integer orderProductIdPk;

	private Integer quantity;

	public OrdersProducts(int orderProductIdPk, int quantity) {
		super();
		this.orderProductIdPk = orderProductIdPk;
		this.quantity = quantity;

	}

	public OrdersProducts() {
		super();
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