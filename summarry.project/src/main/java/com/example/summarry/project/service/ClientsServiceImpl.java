package com.example.summarry.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.summarry.project.dao.ClientsDAO;
import com.example.summarry.project.entity.Accounts;
import com.example.summarry.project.entity.Clients;
@Service
public class ClientsServiceImpl implements ClientsService{
@Autowired
	private ClientsDAO clientsDAO;
	
	@Transactional
	@Override
	public List<Clients> getClients() {
		// TODO Auto-generated method stub
	return	clientsDAO.getClients();
	}
	@Transactional
	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		clientsDAO.deleteClient(id);
	}
	@Transactional
	@Override
	public void saveClient(Clients client) {
		// TODO Auto-generated method stub
		clientsDAO.saveClient(client);
	}
	@Transactional
	@Override
	public Clients getClient(int id) {
		// TODO Auto-generated method stub
		return clientsDAO.getClient(id);
	}
	@Override
	@Transactional
	public List< Accounts> getAcc(int id) {
		// TODO Auto-generated method stub
		return clientsDAO.getAcc(id);
	}
	@Override
	@Transactional
	public Accounts getSingleAcc(int id) {
		// TODO Auto-generated method stub
		return clientsDAO.getSingleAcc(id);
	}
	@Override
	@Transactional
	public Accounts deposit(int theId, long summ) {
		// TODO Auto-generated method stub
		return clientsDAO.deposit(theId, summ);
	}
	@Override
	@Transactional
	public List<Accounts> betweenAcc(int firstId, int secId, long summ) {
	return clientsDAO.betweenAcc(firstId, secId, summ);
		
	}
	@Override
	@Transactional
	public List<Accounts> getAccounts() {
		// TODO Auto-generated method stub
		return clientsDAO.getAccounts();
	}
	@Override
	public int getClienFromAcc(int theId) {
		// TODO Auto-generated method stub
		return clientsDAO.getClienFromAcc(theId);
	}

}
