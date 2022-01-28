package com.ty.hospital.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.hospital.dao.ItemDao;
import com.ty.hospital.dto.Item;

@WebServlet("/createitem")
public class CreateItemServlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String qnt = req.getParameter("qnt");
		String price = req.getParameter("price");
		String message = req.getParameter("message");
		
		Item item = new Item();
		item.setName(name);
		item.setQuantity(Integer.parseInt(qnt));
		item.setPrice(Double.parseDouble(price));
		item.setMessage(message);
		String medOrderId  = (String)req.getParameter("medOrderId");
		ItemDao dao = new ItemDao();
		dao.addItem(item, Integer.parseInt(medOrderId));
		RequestDispatcher dispatcher = req.getRequestDispatcher("create_item.jsp");
		dispatcher.forward(req, resp);
	}
}