package com.gyxz.service;

import java.util.List;

import com.gyxz.DAO.BuildDAOImpl;
import com.gyxz.entity.BuildInfo;

public class BuildService {
	BuildDAOImpl dao = new BuildDAOImpl();

	// 增
	public int addBuild(BuildInfo info) {
		String sql = "insert into build values(null,?,?)";
		Object[] objects = new Object[] { 
				info.getBname(), 
				info.getBtype() 
		};
		return dao.execUpdate(sql, objects);
	}

	// 删
	public int delBuild(Integer id) {
		String sql = "delete from build where id =?";
		Object[] objects = new Object[] { id };
		return dao.execUpdate(sql, objects);
	}

	// 改
	public int UpdateBuild(BuildInfo info) {
		String sql = "update build set bname = ?,btype=?  where id=?";
		Object[] objects = new Object[] { 
				info.getBname(), 
				info.getBtype() , 
				info.getId() };
		return dao.execUpdate(sql, objects);
	}

	// 查
	public List<BuildInfo> QueryBuild() {
		String sql = "select * from build";
		Object[] objects = null;
		return dao.execQuery(sql, objects);
	}

	public BuildInfo QueryBuildById(Integer id) {
		String sql = "select * from build where id = ?";
		Object[] objects = new Object[] { id };
		List<BuildInfo> list = dao.execQuery(sql, objects);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}
}
