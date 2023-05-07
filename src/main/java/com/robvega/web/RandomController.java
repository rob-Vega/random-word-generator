package com.robvega.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Random
 */
@WebServlet("/Random")
public class RandomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RandomController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.isNew()) {
			session.setAttribute("count", 0);
		} else {
			int count = (int) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		
		Random r = new Random();
		String randomWord = "";
		
		for (int i = 1; i <= 10; i++) {
			randomWord += (char) (r.nextInt(26) + 'a');
		}
		
		Date date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("MMM dd, YYYY - kk:mm");
		
		session.setAttribute("randomWord", randomWord.toUpperCase());
		session.setAttribute("date", df.format(date));
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
