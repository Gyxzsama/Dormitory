package com.gyxz.service;

import java.util.ArrayList;
import java.util.List;

import com.gyxz.DAO.StudentDAOImpl;
import com.gyxz.entity.StudentInfo;

public class StudentService {
	StudentDAOImpl dao = new StudentDAOImpl();

	public StudentInfo checkLogin(String uname, String pwd) {
		String sql = "select * from student where suname=? and spwd=?";
		Object[] objects = new Object[] { uname, pwd };
		List<StudentInfo> list = new ArrayList<StudentInfo>();
		list = dao.execQuery(sql, objects);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	
	//修改密码
	public int rstPwd(String id , String pwd) {
		String sql = "update student set spwd=? where id=?";
		Object[] objects = new Object[] { pwd, id };
		return dao.execUpdate(sql, objects);
	}
	//增
	public int addStudent(StudentInfo info) {
		String sql = "insert into student values(null,?,?,?,?,?,?)";
		Object[] objects = new Object[] {
				info.getSuname(),
				info.getSpwd(),
				info.getSname(),
				info.getSsex(),
				info.getState(),
				info.getTel()
		};
		return dao.execUpdate(sql, objects);
	}
	//删
	public int delStudent(Integer id) {
		String sql = "delete from student where id =?";
		Object[] objects = new Object[] {
			id	
		};
		return dao.execUpdate(sql, objects);
	}
	//改
	public int UpdateStudent(StudentInfo info) {
		String sql = "update student set suname = ?,spwd=?,sname=?,ssex=?,state=?,tel=? where id=?";
		Object[] objects = new Object[] {
				info.getSuname(),
				info.getSpwd(),
				info.getSname(),
				info.getSsex(),
				info.getState(),
				info.getTel(),
				info.getId()
		};
		return dao.execUpdate(sql, objects);
	}
	//查
	public List<StudentInfo> QueryStudent() {
		String sql = "select * from student";
		Object[] objects = null;
		return dao.execQuery(sql, objects);
	}
	
	public StudentInfo QueryStudentById(Integer id) {
		String sql = "select * from student where id = ?";
		Object[] objects = new Object[] {id};
		List<StudentInfo> list = dao.execQuery(sql, objects);
		if(list.size() > 0) 
			return list.get(0);
		else
			return null;
	}
}
