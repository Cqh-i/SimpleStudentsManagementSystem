package com.itheima.dao;

import java.sql.SQLException;
import java.util.List;

import com.itheima.bean.Student;

/**   
 * @ClassName:  StudentDao   
 * @Description:这是针对学生表的数据访问
 * @author: Cqh_i
 * @date:   2019年3月25日 下午11:15:08   修改   
 */  
public interface StudentDao {
	
	int PAGE_SIZE = 5; //一页显示多少条记录
	
	/**   
	 * @Description: 查询当页的学生数据
	 * @param: @param currentPage
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Student>      
	 */
	List<Student> findStudentByPage(int currentPage) throws SQLException;
	
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
	 * @Description: 查询总的学生记录  
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: int      
	 */
	int findCount() throws SQLException;
}
