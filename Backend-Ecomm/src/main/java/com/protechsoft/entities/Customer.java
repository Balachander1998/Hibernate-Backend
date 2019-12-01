package com.protechsoft.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Constants;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Customer_Details")
@Getter @Setter @NoArgsConstructor
public class Customer implements Serializable {
	/**
	 * 
	 */		
	private static final long serialVersionUID = 3980102719003229306L;
	private Integer customerId=Integer.MIN_VALUE;
	private String firstName=Constants.EMPTYSTRING;
	private String lastName =Constants.EMPTYSTRING;
	private String emailId=Constants.EMPTYSTRING;
	private String role = Constants.EMPTYSTRING;
	private String line1Addr = Constants.EMPTYSTRING;
	private String line2Addr = Constants.EMPTYSTRING;
	private String mobileNumber = Constants.EMPTYSTRING;
	private String city = Constants.EMPTYSTRING;
	private String state = Constants.EMPTYSTRING;
}
