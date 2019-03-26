package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.bean.PageBean;
import com.itheima.bean.Student;

/**   
 * @ClassName:  StudentService   
 * @Description:这是学生的业务处理规范
 * @author: Cqh_i
 * @date:   2019年3月26日 上午8:33:35   修改   
 */  
public interface StudentService {
	/**   
	 * @Description: 查询所有学生
	 * @return: List<Student>      
	 */
	List<Student> findAll() throws SQLException;
	
	/**   
	 * @Description: 根据ID查询单个学生对象
	 * @param: @param sid
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Student      
	 */
	Student findStudentById(int sid) throws SQLException;
	
	/**   
	 * @Description: 模糊查询，根据姓名或者性别，或者两者兼有
	 * @param: @param sname
	 * @param: @param sgender
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Student>      
	 */
	List<Student> searchStudent(String sname, String sgender) throws SQLException;
	
	/**   
	 * @Description: 添加学生
	 * @param: student 需要添加到数据库的学生对象
	 * @param: @throws SQLException      
	 * @return: void      
	 */
	void insert(Student student) throws SQLException;
	
	/**   
	 * @Description: 根据id删除学生
	 * @param: @param sid
	 * @param: @throws SQLException      
	 * @return: void      
	 */
	void delete(int sid) throws SQLException;
	
	/**   
	 * @Description: 更新学生信息
	 * @param:  student 需要更新的学生数据
	 * @param: @throws SQLException      
	 * @return: void      
	 */
	void update(Student student) throws SQLException;
	
	/**   
	 * @Description:查询当页的数据  
	 * @param: @param currentPage
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: PageBean      
	 */
	PageBean  findStudentByPage(int currentPage) throws SQLException;
}
