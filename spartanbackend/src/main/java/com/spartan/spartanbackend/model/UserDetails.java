package com.spartan.spartanbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class UserDetails {

	@Column(nullable=false)
	@NotBlank(message="Name is mandatory")
	private String user_Name;
	
	
	
	
	@Column(nullable=false,unique=true)
	@NotBlank(message="Email id is mandatory")
	@Email(regexp="[a-z0-9_]+@[a-z]+\\.[a-z]{2,3}")
	private String emailid;
	
	
	@Column(nullable=false)
	@NotBlank(message="Phone Number is mandatory")
	@Pattern(regexp="[6789][0-9]{9}")
	private String phno;
	
	@Column(nullable=false)
	@NotBlank(message="Password is mandatory")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
    @Transient
	private String user_Password;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cart_id;

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getUser_Password() {
		return user_Password;
	}

	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

		
	
}
