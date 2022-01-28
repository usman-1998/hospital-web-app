package com.ty.hospital.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.HospitalDao;
import com.ty.hospital.dto.Hospital;

@WebServlet("/createhospital")
public class CreateHospitalServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hospitalName = req.getParameter("hospitalName");
		String website = req.getParameter("website");
		String gst = req.getParameter("gst");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		
		Hospital hospital = new Hospital();
		hospital.setName(hospitalName);
		hospital.setWebsite(website);
		hospital.setGst(gst);
		HospitalDao hospitalDao = new HospitalDao();
		hospitalDao.addHospital(hospital);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_hospital.jsp");
		dispatcher.forward(req, resp);
	}
}
