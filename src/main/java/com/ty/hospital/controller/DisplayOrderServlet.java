package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.EncounterDao;
import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dto.Encounter;
import com.ty.hospital.dto.MedOrder;

@WebServlet("/displayorder")
public class DisplayOrderServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("encounterId");
		MedOrderDao dao = new MedOrderDao();
		List<MedOrder> medOrders = dao.getAllOrder(Integer.parseInt(id));
		req.setAttribute("medOrders", medOrders);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_order.jsp");
		dispatcher.forward(req, resp);
	}
}
