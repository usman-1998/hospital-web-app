package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;

@WebServlet("/displayencounters")
public class DisplayEncounterServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int personId = Integer.parseInt(req.getParameter("personId"));
		EncounterDao dao = new EncounterDao();
		List<Encounter> encounters = dao.getAllEncounterByPersonId(personId);
		req.setAttribute("encounters", encounters);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_encounter.jsp");
		dispatcher.forward(req, resp);
	}

}
