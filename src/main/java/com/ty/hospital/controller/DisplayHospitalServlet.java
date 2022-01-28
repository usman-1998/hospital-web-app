package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Hospital;

@WebServlet("/getallhospital")
public class DisplayHospitalServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HospitalDao dao = new HospitalDao();
		List<Hospital> hospitals = dao.getAllHospital(0);
		req.setAttribute("hospitals", hospitals);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_hospital.jsp");
		dispatcher.forward(req, resp);
	}
	
}
