package com.demo.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.web.dao.AlienDao;
import com.demo.web.model.Alien;

public class GetAlienController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int aid = Integer.parseInt(request.getParameter("aid"));

		AlienDao dao = new AlienDao();
		Alien al = dao.getAlien(aid);
		
//		request.setAttribute("alien", al);
//
//		RequestDispatcher rd = request.getRequestDispatcher("showAlien.jsp");
//		rd.forward(request, response);
		
		HttpSession session=request.getSession();
		session.setAttribute("alien", al);
		
		response.sendRedirect("showAlien.jsp");
	}

}
