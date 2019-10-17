package br.com.starter.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import br.com.starter.controller.Controller;
import br.com.starter.model.Phones;
import br.com.starter.model.User;

@WebServlet(urlPatterns = "/profile")
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5435371981932739267L;
	private Controller controller;

	public UserServlet() {
		this.controller = new Controller();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> list = new ArrayList<User>();
		list = (List<User>) controller.findAll("User");
		List<String> strings = new ArrayList<String>(list.size());
		for (Object object : list) {
		    strings.add(object != null ? object.toString() : null);
		}
		String json = new Gson().toJson(strings);
	    resp.setContentType("application/json");
	    resp.setCharacterEncoding("UTF-8");
	    resp.getWriter().write(json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		String parameter = req.getParameter("parameter");
		User user;
		Phones phone;
		if (parameter.equals("Signup")) {
			try {
				user = getData(req);
				phone = getPhones(req);
				controller.add(phone);
				controller.add(user);
				session.setAttribute("signedUser", user);
				resp.sendRedirect("login.jsp");
			} catch (Exception e) {
				System.err.println("Erro" + e);
			}
		}
		if (parameter.equals("Update")) {
			phone = getPhones(req);
			user = getData(req);
			controller.update(user);
			resp.sendRedirect("headPanel.jsp");
		}
		if (parameter.equals("Remove")) {
			String idcopy = req.getParameter("id");
			int id = Integer.parseInt(idcopy);
			user = (User) controller.findById(id, "User");
			controller.remove(user);
			session.removeAttribute("user");
			resp.sendRedirect("headPanel.jsp");
		}

	}

	private User getData(HttpServletRequest req) {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		User user = new User(name, email, password, getPhones(req));
		return user;
	}

	private Phones getPhones(HttpServletRequest req) {
		String dddcopy = req.getParameter("ddd");
		int ddd = Integer.parseInt(dddcopy);
		String number = req.getParameter("number");
		String type = req.getParameter("type");
		Phones phone = new Phones(ddd, number, type);
		return phone;
	}

}