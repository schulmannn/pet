package com.example.summarry.project.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.summarry.project.entity.Accounts;
import com.example.summarry.project.entity.Clients;




import org.springframework.data.repository.query.Param;

@Repository

public class ClientsDAOimpl implements ClientsDAO{
	
	
	//DEFINE field for entity manager
	@Autowired
	private EntityManager entityManager;
	
	//setup constructor injection


	@Override

	
	public List<Clients> getClients() {
		
	
	Session currentSession=entityManager.unwrap(Session.class);
	
	Query<Clients>theQuery=
			currentSession.createQuery("FROM Clients group by lastName",Clients.class);
	List<Clients>list=theQuery.getResultList();
	
	return list;
			}

	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		Clients c=entityManager.find(Clients.class, id);
		
		
		entityManager.remove(c);
		
	}

	@Override
	public void saveClient(Clients client) {
		// TODO Auto-generated method stub
		entityManager.merge(client);
	}

	@Override
	public Clients getClient(int id) {
		// TODO Auto-generated method stub
	Clients tempr=	entityManager.find(Clients.class, id);
	return tempr;
	}

	@Override
	public List<Accounts> getAcc(int id) {
		List<Accounts>acc=new ArrayList<>();
		Clients cl=entityManager.find(Clients.class,id);
		acc=cl.getAccounts();
		return acc;
		
           
	
		
		
	
		
	
	}

	@Override
	public Accounts getSingleAcc(int id) {
		// TODO Auto-generated method stub
		Accounts c=entityManager.find(Accounts.class, id);
		return c;
	
	}

	@Override
	public Accounts deposit(int theId, long summ) {
		// TODO Auto-generated method stub
		 Accounts acc=entityManager.find(Accounts.class, theId);
		 acc.setMoney(acc.getMoney()+summ);
		 return acc;
	}

	@Override
	public List<Accounts> betweenAcc(int firstId, int secId, long summ) {
		 Accounts acc1=entityManager.find(Accounts.class, firstId);
		 Accounts acc2=entityManager.find(Accounts.class, secId);
		 acc1.setMoney(acc1.getMoney()-summ);
		 acc2.setMoney(acc2.getMoney()+summ);
		 List<Accounts>list=new ArrayList<>();
		 list.add(acc1);
		 list.add(acc2);
		 return list;
		
	}

	@Override
	public List<Accounts> getAccounts() {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query<Accounts>theQuery=
				currentSession.createQuery("FROM Accounts ",Accounts.class);
		List<Accounts>list2=theQuery.getResultList();
		
		return list2;
	}

	
	  
	
	@Override
	 
	public int getClienFromAcc(int theId) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		
		Query theQuery=
				currentSession.createQuery("FROM Clients group by lastName",Accounts.class);
		
		int id=theQuery.getFirstResult();
		
		
		
		return id;
	}
	
	
		
	

}
