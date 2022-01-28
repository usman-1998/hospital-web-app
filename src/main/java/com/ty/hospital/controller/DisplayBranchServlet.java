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
import com.ty.hospital.dto.Branch;

@WebServlet("/getallbranch")
public class DisplayBranchServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int hospitalId = Integer.parseInt(req.getParameter("hospitalId"));
		BranchDao dao = new BranchDao();
		List<Branch> branchs = dao.getAllBranchesByHospital(hospitalId);
		req.setAttribute("branchs", branchs);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_branch.jsp");
		dispatcher.forward(req, resp);
	}


}
