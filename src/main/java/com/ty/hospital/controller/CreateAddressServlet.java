package com.ty.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.AddressDao;
import com.ty.hospital.dto.Address;

@WebServlet("/createaddress")
public class CreateAddressServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int branchId = Integer.parseInt(req.getParameter("branchId"));
		String address = req.getParameter("address");
		String state = req.getParameter("state");
		String pin = req.getParameter("pin");
		
		Address address2 = new Address();
		address2.setAddress(address);
		address2.setPin(branchId);
		address2.setState(state);
		
		AddressDao addressDao = new AddressDao();
		addressDao.createAddress(address2, branchId);
		RequestDispatcher dispatcher = req.getRequestDispatcher("admin_home.jsp");
		dispatcher.forward(req, resp);
	}

}
