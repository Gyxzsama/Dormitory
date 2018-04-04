package com.gyxz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyxz.entity.BuildInfo;

public class BuildDAOImpl extends BaseDAO<BuildInfo> {

	@Override
	public List<BuildInfo> resultToList(ResultSet rs) throws SQLException {
		List<BuildInfo> list = new ArrayList<BuildInfo>();
		while(rs.next()){
			BuildInfo info =new BuildInfo();
			info.setId(rs.getInt("id"));
			info.setBname(rs.getString("bname"));
			info.setBtype(rs.getString("btype"));
			list.add(info);
		}
		return list;
	}
	

}
