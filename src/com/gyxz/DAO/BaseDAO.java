package com.gyxz.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDAO<T> {

	private String url = "jdbc:mysql://127.0.0.1:3306/db_dormitory";
	private String driver = "com.mysql.jdbc.Driver";
	private String uname = "root";
	private String pwd = "root";
	protected static Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;

	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, uname, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setparmar(PreparedStatement ps,Object ...objects) throws SQLException
	{
		if(objects!=null)
		{
			for(int i = 0;i<objects.length;i++) 
				ps.setObject(i+1, objects[i]);
		}
	}
	public void closeAll() throws SQLException
	{
		if(rs!=null)
			rs.close();
		if(ps!=null)
			ps.close();
		if(conn!=null)
			conn.close();
	}
	public int execUpdate(String sql, Object ...objects)
	{
		int flag = -1;
		getConnection();
		try {
			ps = conn.prepareStatement(sql);
			setparmar(ps,objects);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		  	try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	public List<T> execQuery(String sql, Object ...objects)
	{
		getConnection();
		try {
			ps = conn.prepareStatement(sql);
			setparmar(ps,objects);
			rs = ps.executeQuery();
			return resultToList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
		  	try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public abstract List<T> resultToList(ResultSet rs) throws SQLException;
}