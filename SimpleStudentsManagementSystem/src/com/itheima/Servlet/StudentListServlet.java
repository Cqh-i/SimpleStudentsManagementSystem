package com.itheima.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

/**   
 * @ClassName:  StudentListServlet   
 * @Description:负责查询所有学生的信息，然后呈现到list.jsp页面上
 * @author: Cqh_i
 * @date:   2019年3月25日 下午11:09:51   修改   
 */  
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//1.查询出来所有学生
			StudentService service = new StudentServiceImpl();
			List<Student> list = service.findAll();
			//2.先把数据存储到作用域中
			request.setAttribute("list", list);
			//3.跳转页面
			request.getRequestDispatcher("list.jsp").forward(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
