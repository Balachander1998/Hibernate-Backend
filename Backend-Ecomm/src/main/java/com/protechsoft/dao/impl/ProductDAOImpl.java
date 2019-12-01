package com.protechsoft.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.protechsoft.config.DBConfig;
import com.protechsoft.dao.ProductDAO;
import com.protechsoft.entities.Product;


public class ProductDAOImpl implements ProductDAO {
	private boolean value;
	private Session session;
	@Override
	public boolean addOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			session = DBConfig.getSessionFactory().openSession();
			session.beginTransaction();
			session.saveOrUpdate(product);
			session.getTransaction().commit();
			value=true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return value;
	}

	@Override
	public boolean deleteProduct(int itemCode) {
		// TODO Auto-generated method stub
		try {
			session= DBConfig.getSessionFactory().openSession();
			session.beginTransaction();
			List<Product> productList=session.createSQLQuery("Select * from Products").list();
			for(Product product : productList) {
				if(product.getItemCode()==itemCode) {
					session.delete(product);
					session.getTransaction().commit();
					value =true;
					break;
				}else {
					value=false;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return value;
	}
	

	@Override

	public List<Product> displayProducts() {
		List<Product> productList = new ArrayList<Product>();
		try {
			session=DBConfig.getSessionFactory().openSession();
			session.beginTransaction();
			productList = (List<Product>)session.createCriteria(Product.class).list();
			
			// TODO Auto-generated method stub
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		return productList;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Product displayProduct(int itemCode) {
		Product product = new Product();
		List<Product> productList = new ArrayList<Product>();
		try {
			System.out.println(itemCode);
			session=DBConfig.getSessionFactory().openSession();
			session.beginTransaction();
			productList=(List<Product>)session.createCriteria(Product.class).list();
			for(Product p : productList) {
				if(p.getItemCode()==itemCode) {
					product =p;
					break;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			session.getTransaction().rollback();
		}
		
		return product;
	}

	

}
