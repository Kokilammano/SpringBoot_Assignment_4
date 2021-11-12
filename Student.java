//Create Student class 

package com.abc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student {
	@Id
	@GeneratedValue
	private int roll_no;

	@NotEmpty(message="Name is required")
	private String name;
	
	@NotEmpty(message="Mobile is required")
	private String mobile;
	
	@NotEmpty(message="Email is required")
	private String email;
	
	public Student() {
		super();
	}

	public Student(int roll_no, String name, String mobile, String email) {
		super();
		this.roll_no = roll_no;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	public int getRoll_no() {
		return roll_no;
	}

	public void setRoll_no(int roll_no) {
		this.roll_no = roll_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
