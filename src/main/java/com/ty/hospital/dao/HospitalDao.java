package com.ty.hospital.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;
import com.ty.hospital.dto.Item;

public class HospitalDao {
	

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}
	
	public void addHospital(Hospital hospital) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(hospital);
		entityTransaction.commit();
	}
	
	public void addBranch(Branch branch,Hospital hospital) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		ArrayList<Branch> branchs ;
	}

	public Hospital getHospitalById(int id) {
		entityManager = getEntityManager();
		return entityManager.find(Hospital.class, id);
	}
	
	public List<Hospital> getAllHospital(int medOrderId){
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT h FROM Hospital h ");
		return query.getResultList();	
	}

}
