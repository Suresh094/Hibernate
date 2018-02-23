package com.suresh.Entitys;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private Integer productidPk;

	private String name;

	private String description;

	private double price;

	public Products(Integer productidPk, String name, String description, double price) {
		super();
		this.productidPk = productidPk;
		this.name = name;
		this.description = description;
		this.price = price;
	}

	/*
	 * @OneToMany(mappedBy = "products", fetch = FetchType.EAGER, cascade =
	 * CascadeType.ALL) private List<OrdersProducts> ordersProducts;
	 * 
	 */
	@OneToMany(mappedBy = "products",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrdersProducts> ordersProducts;

	public Products() {
		super();
	}

  	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Products\n [productidPk=");
		builder.append(productidPk+ "\n");
		builder.append(", name=");
		builder.append(name+ "\n");
		builder.append(", description=");
		builder.append(description+ "\n");
		builder.append(", price=");
		builder.append(price);
		builder.append("]\n");
		
		return builder.toString();
	}
	
	

}
