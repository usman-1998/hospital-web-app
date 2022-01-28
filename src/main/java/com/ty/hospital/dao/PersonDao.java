package com.ty.hospital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Person;

public class PersonDao {
	
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	private EntityTransaction entityTransaction;

	private EntityManager getEntityManager() {
		entityManagerFactory = Persistence.createEntityManagerFactory("usman");
		return entityManagerFactory.createEntityManager();
	}
	
	public void createPerson(Person person) {
		
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	
	public void updatePerson(Person person) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(person);
		entityTransaction.commit();
	}
	
	public boolean deletePerson(int id) {
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Person person = entityManager.find(Person.class, id);
		if(person!=null) {
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
			return true;
		}else {
			return false;
			
		}
	}

	public List<Person> getAllPerson() {
		entityManager = getEntityManager();
		Query query = entityManager.createQuery("select p from Person p");
		return query.getResultList();
		
	}
	
	public Person getPersonById(int id) {
		entityManager = getEntityManager();
		return entityManager.find(Person.class, id);
	}
	public List<Branch> getAllPersonById(int personId){
		entityManager = getEntityManager();
		entityTransaction = entityManager.getTransaction();
		Query query = entityManager.createQuery("SELECT p FROM Person p where p.id=?1 ");	
		query.setParameter(1, personId);
		return query.getResultList();	
	}
}
