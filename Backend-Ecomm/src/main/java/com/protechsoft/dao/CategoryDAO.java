package com.protechsoft.dao;

import java.util.List;

import com.protechsoft.entities.Category;
import com.protechsoft.entities.Product;

public interface CategoryDAO {
	public void addCategory(Category category);
	public List<Category> getAllCategories();
}
