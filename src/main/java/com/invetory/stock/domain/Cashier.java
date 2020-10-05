package com.invetory.stock.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cashier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cashier_id;
	private String name;
	private String username;
	private String passwod;
	
	public long getCashier_id() {
		return cashier_id;
	}
	public void setCashier_id(long cashier_id) {
		this.cashier_id = cashier_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswod() {
		return passwod;
	}
	public void setPasswod(String passwod) {
		this.passwod = passwod;
	}
	@Override
	public String toString() {
		return "Cashier [name=" + name + "]";
	}
	
	
	
}
