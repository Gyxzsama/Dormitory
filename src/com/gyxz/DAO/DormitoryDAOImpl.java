package com.gyxz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyxz.entity.DormitoryInfo;

public class DormitoryDAOImpl extends BaseDAO<DormitoryInfo>{

	@Override
	public List<DormitoryInfo> resultToList(ResultSet rs) throws SQLException {
		List<DormitoryInfo> list = new ArrayList<DormitoryInfo>();
		while(rs.next()){
			DormitoryInfo info = new DormitoryInfo();
			info.setId(rs.getInt("id"));
			info.setD_id(rs.getInt("d_id"));
			info.setB_id(rs.getInt("b_id"));
			info.setDtype(rs.getInt("dtype"));
			info.setScount(rs.getInt("scount"));
			info.setTel(rs.getString("tel"));
			list.add(info);
		}
		return list;
	}
	
}
