package com.itheima.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1.获取客户端提交上来的数据
		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String[] hobby = request.getParameterValues("hobby");
		String info = request.getParameter("info");
		
		// String -> Date
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student  = new Student(sid, sname, gender, phone, Arrays.toString(hobby), info, date);
		//2.更新数据库数据
		StudentService service = new StudentServiceImpl();
		try {
			service.update(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3.跳转界面
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
