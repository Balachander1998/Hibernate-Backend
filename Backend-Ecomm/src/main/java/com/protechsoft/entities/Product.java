package com.protechsoft.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PRODUCT")
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//Primary-Key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Product_Id")
	private Integer pId = Integer.MIN_VALUE;
	//Name of the Product
	@Column(name="Product_Name")
	private String  productName;
	//Item code of the product
	@Column(name="Item_Code")
	private Long itemCode= Long.MIN_VALUE;
	// Manufacturer
	@Column(name="Brand_Name")
	private String brandName;
	//Description of the Product
	@Column(length = 10000,name="Product_Description")
	private String productDescription;
	//Category of the Product
	@ManyToOne(optional = false)
	
	@JoinColumn(name = "Category_Id",nullable = false)
	private Category category;
	//Cost of the Product
	@Column(name="Product_Cost")
	private Integer productCost = Integer.MIN_VALUE;
	//Quantity of the Product
	@Column(name="Quantity")
	private Integer quantity = Integer.MIN_VALUE;
	 @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int) (pId^ (pId >>> 32));
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (!(obj instanceof Product))
	            return false;
	        Product other = (Product) obj;
	        if (pId != other.pId)
	            return false;
	        return true;
	    }
	
}
