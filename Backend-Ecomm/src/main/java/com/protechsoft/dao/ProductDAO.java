package com.protechsoft.dao;

import java.util.List;

import com.protechsoft.entities.Product;

public interface ProductDAO {
	public boolean addOrUpdateProduct(Product product);
	public boolean deleteProduct(int itemCode);
	public List<Product> displayProducts();
	public Product displayProduct(int itemCode);
	
	
	
}
