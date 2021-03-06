package com.controler.grade;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AvgGrade;
import com.bean.Teacher;
import com.dao.GradeDao;

/**
 * Servlet implementation class ShowAvgGradeServlet
 */
@WebServlet("/showAvgGrade.do")
public class ShowAvgGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAvgGradeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Teacher t = (Teacher) request.getSession().getAttribute("user");
		String teaId = t.getId();
		String couId = request.getParameter("couId");
		GradeDao d = new GradeDao();
		ArrayList<AvgGrade> list = d.getClassAvgGrade(teaId);
		request.setAttribute("all", list);
		request.getRequestDispatcher("/teacher/queryAvgGrade.jsp").forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
