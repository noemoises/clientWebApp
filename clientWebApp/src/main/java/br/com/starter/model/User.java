package br.com.starter.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "user")
public class User {
	@Id
	@Column
	private int id;
	private static int count = 0;
	@Column
	private String name;

	@Column
	private String email;

	@Column
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_phones", joinColumns = {
			@JoinColumn(name = "user_id", table = "user_phones") }, inverseJoinColumns = {
					@JoinColumn(name = "phones_id", table = "cliente_phones") })
	private List<Phones> phonesList = new LinkedList<Phones>();

	public User() {

	}

	public User(String name, String email, String password, Phones phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		count++;
		this.id = count;
		phonesList.add(phones);
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public List<Phones> getPhonesList() {
		return phonesList;
	}

	public void setPhonesList(List<Phones> phonesList) {
		this.phonesList = phonesList;
	}

	@Override
	public String toString() {
		return "Id: " + this.id + ", Name: " + this.name + ", Email: " + this.email + ", Phones list: " + this.phonesList;
	}

}
