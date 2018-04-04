package com.gyxz.service;

import java.util.ArrayList;
import java.util.List;

import com.gyxz.DAO.AdminDAOImpl;
import com.gyxz.entity.AdminInfo;

public class AdminService {
	private AdminDAOImpl dao = new AdminDAOImpl();
	//登录验证
	public AdminInfo checkLogin(String uname, String pwd) {
		String sql = "select * from admin where auname=? and apwd=?";
		Object[] objects = new Object[] { uname, pwd };
		List<AdminInfo> list = new ArrayList<AdminInfo>();
		list = dao.execQuery(sql, objects);
		if(list.size()>0)
			return list.get(0);
		else
			return null;
	}
	
	//修改密码
	public int rstPwd(String id , String pwd) {
		String sql = "update admin set apwd=? where id=?";
		Object[] objects = new Object[] { pwd, id };
		return dao.execUpdate(sql, objects);
	}
}
