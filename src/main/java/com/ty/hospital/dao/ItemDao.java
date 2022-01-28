package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;

public class ItemDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}
	
	public void addItem(Item item,int medOrderId) {
		entityManager = getEntityManager();
		MedOrder medOrder = new MedOrderDao().getMedOrderById(medOrderId);
		item.setMedOrder(medOrder);
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
	}
	
	public List<Item> getAllItem(int medOrderId){
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT i FROM Item i WHERE i.medOrder.id=?1 ");
		query.setParameter(1, medOrderId);
		return query.getResultList();	
	}

}
