package com.ty.hospital.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ty.hospital.dao.BranchDao;
import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dto.Branch;
import com.ty.hospital.dto.Encounter;

@WebServlet("/createbranch")
public class CreateBranchServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hospitalId  = Integer.parseInt(req.getParameter("hospitalId"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
	
		
		
		Branch branch = new Branch();
		
		
		branch.setName(name);
		branch.setEmail(email);
		BranchDao branchDao = new BranchDao();
		branchDao.createBranch(branch, hospitalId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_branch.jsp");
		dispatcher.forward(req, resp);
	}
}
