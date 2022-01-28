package com.ty.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Person;

public class CreatePersonServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		
		Person person = new Person();
		person.setName(name);
		person.setEmail(email);
		person.setPhone(Long.parseLong(phone));
		person.setAge(Integer.parseInt(age));
		person.setGender(gender);
		
		PersonDao personDao = new PersonDao();
		personDao.createPerson(person);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_person.jsp");
		dispatcher.forward(req, resp);
	}

}
