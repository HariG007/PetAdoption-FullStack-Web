package com.teamx.petadopt.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity//mapped to the table
@Table
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private int id;
	private String Animaltype;
	private String Name;
	private String Sex;
	private String email;
	private int Age;
	private String Breed;
	private String Colour;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    private Login login;
	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public User() {
		super();
	}
	
	public User(int id, String animaltype, String name, String sex, String email, int age, String breed,
			String colour) {
		super();
		this.id = id;
		Animaltype = animaltype;
		Name = name;
		Sex = sex;
		this.email = email;
		Age = age;
		Breed = breed;
		Colour = colour;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnimaltype() {
		return Animaltype;
	}
	public void setAnimaltype(String animaltype) {
		Animaltype = animaltype;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getBreed() {
		return Breed;
	}
	public void setBreed(String breed) {
		Breed = breed;
	}
	public String getColour() {
		return Colour;
	}
	public void setColour(String colour) {
		Colour = colour;
	}
}
