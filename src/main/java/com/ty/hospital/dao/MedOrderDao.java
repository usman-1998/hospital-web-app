package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.MedOrder;

public class MedOrderDao {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}
	
	public void createOrder(int encounterId,MedOrder medOrder) {
		entityManager = getEntityManager();
		Encounter encounter = new EncounterDao().getEncounterByid(encounterId);
		medOrder.setEncounter(encounter);
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(medOrder);
		entityTransaction.commit();
	}
	
	public List<MedOrder> getAllOrder(int encounterId){
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT m FROM MedOrder m ");
		return query.getResultList();	
	}
	
	public boolean deleteOrder(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		MedOrder medOrder = entityManager.find(MedOrder.class, id);
		if(medOrder!=null) {
			entityTransaction.begin();
			entityManager.remove(medOrder);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	public MedOrder getMedOrderById(int id) {
		entityManager = getEntityManager();
		return entityManager.find(MedOrder.class, id);
	}
}
