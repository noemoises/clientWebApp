package br.com.starter.model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phones")
public class Phones {
	@Id
	@Column
	private int id;
	private static int count;
	
	@Column
	private int ddd;
	
	@Column
	private String number;
	
	@Column
	private String type;
	
	@ManyToMany(mappedBy = "phonesList", fetch = FetchType.EAGER)
	List<User> usersList = new LinkedList<User>();
	
	public Phones() {
	}

	public Phones(int ddd, String number, String type) {
		this.ddd = ddd;
		this.number = number;
		this.type = type;
		count++;
		this.id = count;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "DDD: " + this.ddd + ", Phone number: " + this.number + ", Type: " + this.type;
	}
}
