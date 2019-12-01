package com.protechsoft.config;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.protechsoft.entities.Category;
import com.protechsoft.entities.Product;

public class DBConfig {
	private static StandardServiceRegistry serviceRegistry;
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory==null) {
			try {
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
				Map<String,String> settings = new HashMap<String, String>();
				settings.put(Environment.DRIVER, "org.h2.Driver");
				settings.put(Environment.URL, "jdbc:h2:tcp://localhost/~/Employee");
				settings.put(Environment.USER, "balachander");
				settings.put(Environment.PASS, "bala@123");
				settings.put(Environment.HBM2DDL_AUTO,"update");
				settings.put(Environment.SHOW_SQL,"true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				builder.applySettings(settings);
				serviceRegistry= builder.build();
				MetadataSources sources = new MetadataSources(serviceRegistry);
				sources.addAnnotatedClass(Product.class);
				sources.addAnnotatedClass(Category.class);
				Metadata data = sources.getMetadataBuilder().build();
				sessionFactory=data.buildSessionFactory();
				
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
				
			}
			
			
		}
		
		return sessionFactory;
	}
	
}
