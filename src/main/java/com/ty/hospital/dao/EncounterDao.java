package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.Person;

public class EncounterDao {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}
	
	public void crateEncounter(int personId,int branchId,Encounter encounter) {
		Branch branch = new BranchDao().getBranchById(branchId);
		Person person = new PersonDao().getPersonById(personId);
		encounter.setBranch(branch);
		encounter.setPerson(person);
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(encounter);
		entityTransaction.commit();
	}
	
	public Encounter getEncounterByid(int id) {
		entityManager = getEntityManager();
		return entityManager.find(Encounter.class, id);
	}
	
	public boolean deleteEncounter(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Encounter encounter = entityManager.find(Encounter.class, id);
		if(encounter!=null) {
			entityTransaction.begin();
			entityManager.remove(encounter);
			entityTransaction.commit();
			return true;
		}else {
			return false;
		}
	}
	
	public List<Encounter> getAllEncounter(int personId) {
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("Select e from Encounter e");
		return query.getResultList();
	}
	
	public List<Encounter> getAllEncounterByPersonId(int personId){
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT e FROM Encounter e where e.person.id=?1 ");	
		query.setParameter(1, personId);
		return query.getResultList();	
	}
}
