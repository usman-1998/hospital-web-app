package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Encounter;

@WebServlet("/getencounters")
public class GetEncountersServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		EncounterDao dao = new EncounterDao();
		List<Encounter> encounters ;
	}

}
