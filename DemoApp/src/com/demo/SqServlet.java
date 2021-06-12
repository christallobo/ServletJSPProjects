package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/sq")
public class SqServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// RequestDispatcher
//		int k=(int)req.getAttribute("k");
		// end RequestDispatcher

		// sendRedirect
		// url- redirect
//		int k=Integer.parseInt(req.getParameter("k"));

		// session
//		HttpSession session = req.getSession();
//		int k = (int) session.getAttribute("k");

		// Cookie
		int k = 0;
		Cookie cookies[] = req.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("k")) {
				k = Integer.parseInt(c.getValue());
			}
		}

		// end sendRedirect

		k = k * k;

		PrintWriter out = res.getWriter();
		out.print("result is " + k);
	}
}
