package com.teamx.petadopt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name ="orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Transient
	private String Firstname;
	@Transient
	private String Lastname;
	private Long price;
	private Long quantity;
	private String Fullname;
	@Transient//To Avoid Certain Column
	private Long totalPrice;

	public Order() {
		super();
	}
	public Order(Long id, String firstname, Long price, Long quantity, Long totalPrice,String lastname) {
		super();
		this.id = id;
		this.Firstname = firstname;
		this.price = price;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.Lastname= lastname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return Firstname;
	}
	public void setFirstname(String firstname) {
		this.Firstname = firstname;
	}
	public String getLastname() {
		return Lastname;
	}
	public void setLirstname(String lastname) {
		this.Lastname = lastname;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setFullname()
	{
		this.Fullname=Firstname+" "+Lastname;
	}
}
