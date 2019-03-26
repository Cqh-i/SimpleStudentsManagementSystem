package com.itheima.Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itheima.bean.Student;
import com.itheima.service.StudentService;
import com.itheima.service.impl.StudentServiceImpl;

/**   
 * @ClassName:  EditServlet   
 * @Description:处理单个学生的更新，查询一个学生的信息，然后跳转到更新页面
 * @author: Cqh_i
 * @date:   2019年3月26日 下午2:34:55   修改   
 */  
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.接收id	
		int sid = Integer.parseInt(request.getParameter("sid"));
		//2.查询学生数据
		StudentService service = new StudentServiceImpl();
		Student stu = null;
		try {
			stu = service.findStudentById(sid);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//3.显示数据(存数据，跳转)
		request.setAttribute("stu", stu);
		request.getRequestDispatcher("edit.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
