package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Hospital;

public class BranchDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}
	public boolean createBranch(Branch branch,int hositalId) {
		Hospital hospital = new HospitalDao().getHospitalById(hositalId);
		if(hospital != null) {
			entityManager = getEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			branch.setHospital(hospital);
			entityManager.persist(branch);
//			entityManager.persist(branch.getAddress());
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public Branch getBranchById(int id) {
		entityManager = getEntityManager();
		return entityManager.find(Branch.class, id);
	}
	
	public List<Branch> getAllBranches(int hospitalId){
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT b FROM Branch b ");
//		query.setParameter(1, hospitalId);
		return query.getResultList();	
	}
	
	public boolean deleteBranch(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Branch branch = entityManager.find(Branch.class, id);
		if(branch!=null) {
			entityTransaction.begin();
			entityManager.remove(branch);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	public List<Branch> getAllBranchesByHospital(int hospitalId){
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT b FROM Branch b where b.hospital.id=?1 ");	
		query.setParameter(1, hospitalId);
		return query.getResultList();	
	}
}
