package com.gyxz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyxz.entity.StuInInfo;

public class StuInDAOImpl extends BaseDAO<StuInInfo>{
	@Override
	public List<StuInInfo> resultToList(ResultSet rs) throws SQLException {
		List<StuInInfo> list = new ArrayList<StuInInfo>();
		while(rs.next()) {
			StuInInfo info = new StuInInfo();
			info.setId(rs.getInt("id"));
			info.setS_id(rs.getInt("s_id"));
			info.setB_id(rs.getInt("b_id"));
			info.setD_id(rs.getInt("d_id"));
			list.add(info);
		}
		return list;
	}
}
