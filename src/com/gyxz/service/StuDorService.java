package com.gyxz.service;

import java.util.List;

import com.gyxz.DAO.StuInDAOImpl;
import com.gyxz.DAO.StuOutDAOImpl;
import com.gyxz.entity.StuInInfo;
import com.gyxz.entity.StuOutInfo;

public class StuDorService {
	private StuInDAOImpl dao = new StuInDAOImpl();

	public int addStuIn(StuInInfo info) {
		String sql = "insert into stu_in values(null,?,?,?)";
		Object[] objects = new Object[] { info.getS_id(), info.getB_id(), info.getD_id() };
		return dao.execUpdate(sql, objects);
	}

	public StuInInfo QueryInInfoById(Integer id) {

		String sql = "select * from stu_in where s_id =?";
		Object[] objects = new Object[] { id };
		List<StuInInfo> list = dao.execQuery(sql, objects);
		if (list.size()>0)
			return list.get(0);
		else
			return null;
	}

	public int delete(Integer id) {
		String sql = "delete from stu_in where id =?";
		Object[] objects = new Object[] { id };
		return dao.execUpdate(sql, objects);
	}

	public int addStuOut(StuInInfo ininfo, String remarks) {
		String sql = "insert into stu_out values(null,?,?,?,?)";
		Object[] objects = new Object[] { ininfo.getS_id(), ininfo.getB_id(), ininfo.getD_id(), remarks };
		return dao.execUpdate(sql, objects);
	}

	public List<StuOutInfo> QueryOutInfo() {
		String sql = "select * from stu_out ";
		Object[] objects = null;
		return new StuOutDAOImpl().execQuery(sql, objects);
	}
}
