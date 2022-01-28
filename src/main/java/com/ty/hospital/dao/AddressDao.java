package com.ty.hospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.hospital.dto.Address;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public class AddressDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}
	public boolean createAddress(Address address,int branchId) {
		Branch branch = new BranchDao().getBranchById(branchId);
		if(branch != null) {
			entityManager = getEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			branch.setAddress(address);
			address.setBranch(branch);
			entityManager.persist(address);
			entityManager.merge(branch);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}

}
