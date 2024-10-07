package com.FoodApp.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FoodApp.DAO.userDAO;
import com.FoodApp.DAOImpl.userDAOImpl;
import com.FoodApp.Model.user;

@WebServlet("/userServlet")
public class userServlet extends HttpServlet {
	private userDAO userDao = new userDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");

		user user = new user( name, password, email, phone, address, address);

		userDAO dao = new userDAOImpl();
		int x = dao.insertUser(user);


		if(x==0) {
			response.getWriter().println("User is fail to store.");
		} else {
			response.sendRedirect("com.FoodApp.Servlets.HomeServlet");
		}
	}
}
