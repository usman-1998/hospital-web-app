package com.ty.hospital.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dao.MedOrderDao;
import com.ty.hospital.dto.Item;
import com.ty.hospital.dto.MedOrder;

@WebServlet("/displayitem")
public class DisplayItemServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("medOrderId");
		ItemDao dao = new ItemDao();
		List<Item> items = dao.getAllItem(Integer.parseInt(id));
		req.setAttribute("items", items);
		RequestDispatcher dispatcher = req.getRequestDispatcher("display_item.jsp");
		dispatcher.forward(req, resp);
	}

}
