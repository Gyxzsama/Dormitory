package com.gyxz.tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.gyxz.entity.BuildInfo;
import com.gyxz.entity.DormitoryInfo;
import com.gyxz.entity.ManagerInfo;
import com.gyxz.entity.StudentInfo;

public class Tools {
	//判断登录状态
	public static void checkSession() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		try {
			PrintWriter out = response.getWriter();
			if(session.getAttribute("id")==null){
				out.print("<script language='javascript'>"
						+ "alert('登录已失效！');"
						+ "window.location='Login.jsp';"
						+ "</script>");
				out.flush();
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//判断是否操作失败，操作失败则对应跳转
	public static void returnMsg(int i , String s ){
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
		}
		if(i <= 0) {
			out.print("<script language='javascript'>alert('操作失败:');window.location='"+s+"';</script>");
			out.flush();
			out.close();
		}
	}
	//将获取数据中不应该为空的部分
	public static ManagerInfo CheckContent(ManagerInfo a, ManagerInfo b){
		if(b.getMuname()=="")
			b.setMuname(a.getMuname());
		if(b.getMpwd()=="")
			b.setMpwd(a.getMpwd());
		if(b.getMname()=="")
			b.setMname(a.getMname());
		if(b.getMsex()=="")
			b.setMsex(a.getMsex());
		return b;
	}
	public static StudentInfo CheckContent(StudentInfo a, StudentInfo b){
		if(b.getSuname()=="")
			b.setSuname(a.getSuname());
		if(b.getSpwd()=="")
			b.setSpwd(a.getSpwd());
		if(b.getSname()=="")
			b.setSname(a.getSname());
		if(b.getSsex()=="")
			b.setSsex(a.getSsex());
		if(null == b.getState())
			b.setState(a.getState());
		return b;
	}
	public static BuildInfo CheckContent(BuildInfo a, BuildInfo b) {
		if(b.getBname()=="")
			b.setBname(a.getBname());
		if(null ==b.getBtype())
			b.setBtype(a.getBtype());
		return b;
	}
	public static DormitoryInfo CheckContent(DormitoryInfo a, DormitoryInfo b) {
		if(null == b.getD_id())
			b.setD_id(a.getD_id());
		if(null == b.getB_id())
			b.setB_id(a.getB_id());
		if(null == b.getDtype())
			b.setB_id(a.getDtype());
		if(null == b.getScount())
			b.setScount(a.getScount());
		return b;
	}
}