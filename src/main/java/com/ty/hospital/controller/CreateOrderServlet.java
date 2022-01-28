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

import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dto.MedOrder;

@WebServlet("/createorder")
public class CreateOrderServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String encounterId = req.getParameter("encounterId");
		HttpSession httpSession = req.getSession();
		String createrName = (String)httpSession.getAttribute("name");
		String dateTime = req.getParameter("dateTime");
		String message = req.getParameter("message");
		int parEncounterId = Integer.parseInt(encounterId);
		
		MedOrder medOrder = new MedOrder();
		medOrder.setCreateDateTime(LocalDateTime.parse(dateTime, DateTimeFormatter.ISO_DATE_TIME));
		medOrder.setMessage(message);
		medOrder.setCreatorName(createrName);
		
		MedOrderDao dao = new MedOrderDao();
		dao.createOrder(parEncounterId, medOrder);
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_order.jsp");
		dispatcher.forward(req, resp);
		
	}
}
