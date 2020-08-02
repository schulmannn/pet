package com.example.summarry.project.service;

import java.util.List;

import com.example.summarry.project.entity.Accounts;
import com.example.summarry.project.entity.Clients;

public interface ClientsService {

	
	List<Clients> getClients();
	void deleteClient(int id);
	void saveClient(Clients client);
	Clients getClient(int id);
	List<Accounts> getAcc(int id);
	Accounts  getSingleAcc(int id);
	Accounts deposit(int theId,long summ);
	List<Accounts> betweenAcc(int firstId,int secId,long summ);
	List<Accounts>getAccounts();
	int getClienFromAcc(int theId);
}
