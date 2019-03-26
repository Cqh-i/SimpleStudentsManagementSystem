package com.itheima.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收id
		int sid = Integer.parseInt(request.getParameter("sid"));
		//2.执行删除
		StudentService service = new StudentServiceImpl();
		try {
			service.delete(sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3.跳转到列表页
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
