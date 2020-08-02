package com.example.summarry.project.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="bank_account")
public class Accounts {
	
	@ManyToOne( cascade= {CascadeType.ALL})
			
	@JoinColumn(name="client_id")
	
	private Clients clients;
	
	
	
	
	
	

	@Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="money")
	private long money;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getMoney() {
		return money;
	}

	public void setMoney(long money) {
		this.money = money;
	}
	
	public Accounts() {
		
	}

	public Accounts(long money) {
		
		this.money = money;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}
	

	
	
	
}
