package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.PersonDao;
import com.ty.hospital.dto.Person;

@WebServlet("/getall")
public class GetPersonsServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Person> persons = new PersonDao().getAllPerson();
		req.setAttribute("persons", persons);
		RequestDispatcher dispatcher = req.getRequestDispatcher("diplayAllPerson.jsp");
		dispatcher.forward(req, resp);
	}

}
