package com.gyxz.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gyxz.entity.AdminInfo;

public class AdminDAOImpl extends BaseDAO<AdminInfo>{

	@Override
	public List<AdminInfo> resultToList(ResultSet rs) throws SQLException {

		List<AdminInfo> list = new ArrayList<AdminInfo>();
		while(rs.next()) {
			AdminInfo admin = new AdminInfo();
			admin.setId(rs.getInt("id"));
			admin.setAuname(rs.getString("auname"));
			admin.setApwd(rs.getString("apwd"));
			admin.setAname(rs.getString("aname"));
			admin.setAsex(rs.getString("asex"));
			admin.setTel(rs.getString("tel"));
			list.add(admin);
		}
		return list;
	}
}
