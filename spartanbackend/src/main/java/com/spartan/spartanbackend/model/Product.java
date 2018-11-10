package com.spartan.spartanbackend.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Product {

	@Column(nullable = false)
	@NotBlank(message = "Product Name is mandatory")
	private String product_Name;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;

	@Column(nullable = false, columnDefinition = "text")
	@NotBlank(message = "Product Description is mandatory")
	private String productDesc;

	@Column(nullable = false)
	@NotBlank(message = "Quantity is mandatory")
	@Min(value=10,message="Quantity should be 10 minimum")
	private String quantity;

	@Column(nullable = false)
	@NotBlank(message = "Price is mandatory")
	@Min(value=1,message="Price should be Rs1 minimum")
	private String price;

	@ManyToOne()
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Category category;

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Transient
	MultipartFile pimage;

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	
}
