package com.protechsoft.dao.impl;

import java.util.List;
import org.hibernate.Session;
import com.protechsoft.config.DBConfig;
import com.protechsoft.dao.CategoryDAO;
import com.protechsoft.entities.Category;

public class CategoryDAOImpl  implements CategoryDAO{
	private Session session;
	private List<Category> categoryList;
	
	@Override
	public void addCategory(Category category) {
		// TODO Auto-generated method stub
		
		try {
			
			session = DBConfig.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(category);
			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		try {
			session=DBConfig.getSessionFactory().openSession();
			session.beginTransaction();
			categoryList=session.createCriteria(Category.class).list();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return categoryList;
	}


}
