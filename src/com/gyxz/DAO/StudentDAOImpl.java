package com.gyxz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyxz.entity.StudentInfo;

public class StudentDAOImpl extends BaseDAO<StudentInfo>{
	@Override
	public List<StudentInfo> resultToList(ResultSet rs) throws SQLException {
		List<StudentInfo> list = new ArrayList<StudentInfo>();
		while(rs.next()) {
			StudentInfo stu =new StudentInfo();
			stu.setId(rs.getInt("id"));
			stu.setSuname(rs.getString("suname"));
			stu.setSpwd(rs.getString("spwd"));
			stu.setSname(rs.getString("sname"));
			stu.setSsex(rs.getString("ssex"));
			stu.setState(rs.getInt("state"));
			stu.setTel(rs.getString("tel"));
			list.add(stu);
		}
		return list;
	}
}
