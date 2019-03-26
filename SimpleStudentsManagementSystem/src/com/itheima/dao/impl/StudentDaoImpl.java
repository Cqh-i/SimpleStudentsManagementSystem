package com.itheima.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.bean.Student;
import com.itheima.dao.StudentDao;
import com.itheima.util.JDBCUtil;
import com.itheima.util.TextUtils;

/**   
 * @ClassName:  StudentDaoImpl   
 * @Description:这是StudentDao的shixian.zhendui前面定义的规范，做出的具体实现。
 * @author: Cqh_i
 * @date:   2019年3月25日 下午11:24:50   修改   
 */  
public class StudentDaoImpl implements StudentDao {

	/* 
	 *查询所有学生
	 */
	@Override
	public List<Student> findAll() throws SQLException { 
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu";
		List<Student> list = runner.query(sql, new BeanListHandler<Student>(Student.class));
		return list;
	}

	@Override
	public void insert(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "insert into stu values(null, ?,?,?,?,?,?)";
		runner.update(sql, student.getSname(), student.getGender(), student.getPhone(),student.getBirthday(),student.getHobby(), student.getInfo());
	}

	@Override
	public void delete(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "delete from stu where sid = ?";
		runner.update(sql, sid);
	}

	@Override
	public Student findStudentById(int sid) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu where sid = ?";
		Student student = runner.query(sql, new BeanHandler<Student>(Student.class), sid);
		return student;
	}

	@Override
	public void update(Student student) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "update stu set sname = ?,  gender = ?, phone = ?, birthday = ?, hobby = ?, info = ? where sid = ?";
		runner.update(sql, student.getSname(), student.getGender(), student.getPhone(),student.getBirthday(),student.getHobby(), student.getInfo(), student.getSid());
	}

	@Override
	public List<Student> searchStudent(String sname, String sgender) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select * from stu where 1 = 1";
		List<String> list = new ArrayList<String>();
		if(!TextUtils.isEmpty(sname)) {
			sql = sql + " and sname like ?";
			list.add("%" + sname + "%");
		}
		if(!TextUtils.isEmpty(sgender)) {
			sql = sql + " and gender = ?";
			list.add(sgender);
		}
		return runner.query(sql, new BeanListHandler<Student>(Student.class), list.toArray());
	}

	@Override
	public List<Student> findStudentByPage(int currentPage) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		//第一个问号代表一页返回多少条记录，第二个问号代表跳过前面的多少条记录
		String sql = "select * from stu limit ? offset ?";
		return runner.query(sql, new BeanListHandler<Student>(Student.class), PAGE_SIZE, (currentPage - 1) * PAGE_SIZE);
	}

	@Override
	public int findCount() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());
		String sql = "select count(*) from stu";
		Long result = (Long) runner.query(sql, new ScalarHandler());
		return result.intValue();
	}

}
