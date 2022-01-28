package com.ty.hospital.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Encounter;

@WebServlet("/createencounter")
public class CraeteEncounterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession httpSession = req.getSession();
		Integer branchId = (Integer)httpSession.getAttribute("branchId");
		String name = (String)httpSession.getAttribute("name");
		String reason = req.getParameter("reason");
		
		String dateTime = req.getParameter("dateTime");
		LocalDateTime  admitDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME);
		
		Encounter encounter = new Encounter();
		encounter.setReason(reason);
		encounter.setCreatorName(name);
		encounter.setDate(admitDateTime);
		encounter.setReason(reason);
		String id = req.getParameter("personId");
		int personId = Integer.parseInt(id);
		System.out.println(personId);
		
		EncounterDao encounterDao = new EncounterDao();
		encounterDao.crateEncounter(personId, branchId, encounter);
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_encounter.jsp");
		dispatcher.forward(req, resp);
		
	}
}
