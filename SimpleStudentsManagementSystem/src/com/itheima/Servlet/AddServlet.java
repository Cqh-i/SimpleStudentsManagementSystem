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

/**   
 * @ClassName:  AddServlet   
 * @Description:用于处理学生的添加请求
 * @author: Cqh_i
 * @date:   2019年3月26日 上午10:38:49   修改   
 */  
public class AddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//1.获取客户端提交上来的数据
		String sname = request.getParameter("sname");
		String gender = request.getParameter("gender");
		String phone = request.getParameter("phone");
		String birthday = request.getParameter("birthday");
		String[] hobby = request.getParameterValues("hobby");
		String info = request.getParameter("info");
		
		//2.添加到数据库
		//String -> Date
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Student student  = new Student(sname, gender, phone, Arrays.toString(hobby), info, date);
		StudentService service = new StudentServiceImpl();
		try {
			service.insert(student);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3.跳转到列表页
		//这里直接跳转到页面上，这个页面会重新翻译一次，上面的那个request的请求存放数据没有了
		//request.getRequestDispatcher("list.jsp").forward(request, response);
		
		//servlet除了能跳转到jsp之外，还能跳转到servlet
		request.getRequestDispatcher("StudentListServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
