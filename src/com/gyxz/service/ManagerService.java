package com.gyxz.service;

import java.util.ArrayList;
import java.util.List;

import com.gyxz.DAO.ManagerDAOImpl;
import com.gyxz.entity.ManagerInfo;

public class ManagerService {
	private ManagerDAOImpl dao = new ManagerDAOImpl();

	public ManagerInfo checkLogin(String uname, String pwd) {
		String sql = "select * from manager where muname=? and mpwd=?";
		Object[] objects = new Object[] { uname, pwd };
		List<ManagerInfo> list = new ArrayList<ManagerInfo>();
		list = dao.execQuery(sql, objects);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
	//修改密码
	public int rstPwd(String id , String pwd) {
		String sql = "update manager set mpwd=? where id=?";
		Object[] objects = new Object[] { pwd, id };
		return dao.execUpdate(sql, objects);
	}
	//增
	public int addManager(ManagerInfo info) {
		String sql = "insert into manager values(null,?,?,?,?,?)";
		Object[] objects = new Object[] {
				info.getMuname(),
				info.getMpwd(),
				info.getMname(),
				info.getMsex(),
				info.getTel(),
		};
		return dao.execUpdate(sql, objects);
	}
	//删
	public int delManager(Integer id) {
		String sql = "delete from manager where id =?";
		Object[] objects = new Object[] {
			id	
		};
		return dao.execUpdate(sql, objects);
	}
	//改
	public int UpdateManager(ManagerInfo info) {
		String sql = "update manager set muname = ?,mpwd=?,mname=?,msex=?,tel=? where id=?";
		Object[] objects = new Object[] {
				info.getMuname(),
				info.getMpwd(),
				info.getMname(),
				info.getMsex(),
				info.getTel(),
				info.getId()
		};
		return dao.execUpdate(sql, objects);
	}
	//查
	public List<ManagerInfo> QueryManager() {
		String sql = "select * from manager";
		Object[] objects = null;
		return dao.execQuery(sql, objects);
	}
	public ManagerInfo QueryManagerById(Integer id) {
		String sql = "select * from manager where id = ?";
		Object[] objects = new Object[] {id};
		List<ManagerInfo> list = dao.execQuery(sql, objects);
		if(list.size() > 0) 
			return list.get(0);
		else
			return null;
	}
}
