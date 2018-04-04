package com.gyxz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyxz.entity.ManagerInfo;

public class ManagerDAOImpl extends BaseDAO<ManagerInfo>{

	@Override
	public List<ManagerInfo> resultToList(ResultSet rs) throws SQLException {
		List<ManagerInfo> list = new ArrayList<ManagerInfo>();
		while(rs.next()) {
			ManagerInfo manager = new ManagerInfo();
			manager.setId(rs.getInt("id"));
			manager.setMuname(rs.getString("muname"));
			manager.setMpwd(rs.getString("mpwd"));
			manager.setMname(rs.getString("mname"));
			manager.setMsex(rs.getString("msex"));
			manager.setTel(rs.getString("tel"));
			list.add(manager);
		}
		return list;
	}
	
}
