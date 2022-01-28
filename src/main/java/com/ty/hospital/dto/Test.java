package com.ty.hospital.dto;

import java.time.LocalDateTime;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dao.UserDao;

public class Test {

	public static void main(String[] args) {	

		/*Person person = new Person();
		person.setName("raju");
		person.setAge(22);
		person.setEmail("raju@gmail.com");
		person.setGender("male");
		person.setPhone(3435);
		PersonDao dao = new PersonDao();
		dao.createPerson(person);
		Hospital hospital = new Hospital();
		hospital.setName("Appolo");
		hospital.setWebsite("wwww.appolo.in");
		hospital.setGst("DG876FVF6");
		
		HospitalDao hospitalDao = new HospitalDao();
		hospitalDao.addHospital(hospital);
		Branch branch = new Branch();
		branch.setName("B-1");
		
		Address address = new Address();
		address.setAddress("smg");
		address.setState("karnataka");
		address.setPin(87654);
	
		branch.setAddress(address);
		
		BranchDao branchDao = new BranchDao();
		branchDao.createBranch(branch, 1);
		
		User user = new User();
		user.setEmail("raju@gmail.com");
		user.setName("raju");
		user.setRole("nurse");
		user.setPassword("123");
		user.setPhone(9876543);
		UserDao userDao = new UserDao();
		userDao.createUser(1, user);
		
		
		MedOrder medOrder = new MedOrder();
		medOrder.setCreateDateTime(LocalDateTime.now());
		medOrder.setCreatorName("deepak");
		medOrder.setMessage("medicien for fever");
		MedOrderDao medOrderDao = new MedOrderDao();
		medOrderDao.createOrder(0, medOrder);
		
		Item item = new Item();
		item.setMessage("dolo");
		item.setName("usman");
		item.setPrice(65);
		item.setQuantity(2);
		
		ItemDao itemDao = new  ItemDao();
		itemDao.addItem(item, 1);*/
		
		Encounter encounter = new Encounter();
		encounter.setDate(LocalDateTime.now());
		encounter.setCreatorName("usman");
		encounter.setReason("fever");
		encounter.setId(2);
		EncounterDao encounterDao = new EncounterDao();
		encounterDao.crateEncounter(1,1, encounter);
		
	}

}
