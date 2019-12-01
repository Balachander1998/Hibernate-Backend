package com.protechsoft.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CATEGORY")
@NoArgsConstructor
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
public class Category implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2751370641432793396L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Category_Id")
	private Integer categoryId;
	@Column(name="Category_Name")
	private String categoryName;
	@OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
	@Column(name="Category_ID")
	private List<Product> productList;
	
}
