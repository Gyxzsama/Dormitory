package com.gyxz.service;

import java.util.List;

import com.gyxz.DAO.DormitoryDAOImpl;
import com.gyxz.entity.DormitoryInfo;

public class DormitoryService {
	DormitoryDAOImpl dao = new DormitoryDAOImpl();
	
	// 增
	public int addDormitory(DormitoryInfo info) {
		String sql = "insert into dormitory values(null,?,?,?,null,?)";
		Object[] objects = new Object[] { 
				info.getD_id(), 
				info.getB_id(), 
				info.getDtype(), 
				info.getTel()
		};
		return dao.execUpdate(sql, objects);
	}

	// 删
	public int delDormitory(Integer id) {
		String sql = "delete from dormitory where id =?";
		Object[] objects = new Object[] { id };
		return dao.execUpdate(sql, objects);
	}

	// 改
	public int UpdateDormitory(DormitoryInfo info) {
		String sql = "update dormitory set d_id = ? ,b_id=?,dtype=?,scount=?,tel=? where id=?";
		Object[] objects = new Object[] { 
				info.getD_id(), 
				info.getB_id(), 
				info.getDtype(), 
				info.getScount(),
				info.getTel(), 
				info.getId() };
		return dao.execUpdate(sql, objects);
	}

	// 查
	public List<DormitoryInfo> QueryDormitory() {
		String sql = "select * from dormitory";
		Object[] objects = null;
		return dao.execQuery(sql, objects);
	}

	public DormitoryInfo QueryDormitoryById(Integer id) {
		String sql = "select * from dormitory where id = ?";
		Object[] objects = new Object[] { id };
		List<DormitoryInfo> list = dao.execQuery(sql, objects);
		if (list.size() > 0)
			return list.get(0);
		else
			return null;
	}

	public List<DormitoryInfo> QueryDormitoryByBid(String id) {
		String sql = "select * from dormitory where b_id = ?";
		Object[] objects = new Object[] { id };
		return dao.execQuery(sql, objects);
	}
}
