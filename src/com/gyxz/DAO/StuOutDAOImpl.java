package com.gyxz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyxz.entity.StuOutInfo;

public class StuOutDAOImpl extends BaseDAO<StuOutInfo>{

	@Override
	public List<StuOutInfo> resultToList(ResultSet rs) throws SQLException {
		List<StuOutInfo> list = new ArrayList<StuOutInfo>();
		while(rs.next()) {
			StuOutInfo info = new StuOutInfo();
			info.setId(rs.getInt("id"));
			info.setS_id(rs.getInt("s_id"));
			info.setB_id(rs.getInt("b_id"));
			info.setD_id(rs.getInt("d_id"));
			info.setRemarks(rs.getString("remarks"));
			list.add(info);
		}
		return list;
	}
	

}
