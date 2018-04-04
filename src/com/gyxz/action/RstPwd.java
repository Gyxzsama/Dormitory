package com.gyxz.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gyxz.entity.AdminInfo;
import com.gyxz.entity.ManagerInfo;
import com.gyxz.entity.StudentInfo;
import com.gyxz.service.AdminService;
import com.gyxz.service.ManagerService;
import com.gyxz.service.StudentService;
import com.gyxz.tool.Tools;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { 
		@Result(name = "success", location = "/RstPwd.jsp")
})
//修改密码
public class RstPwd extends ActionSupport implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String pwd0;
	private String pwd1;
	private String pwd2;
	private String msg;
	public String getPwd0() {
		return pwd0;
	}

	public void setPwd0(String pwd0) {
		this.pwd0 = pwd0;
	}

	public String getPwd1() {
		return pwd1;
	}

	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	public String getPwd2() {
		return pwd2;
	}
	public void setPwd2(String pwd2) {
		this.pwd2 = pwd2;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public void prepare() throws Exception {
		Tools.checkSession();
	}
	
	@Action("rstPwd")
	public String rstPwd(){
		
		//获取登录类型
		HttpSession session = ServletActionContext.getRequest().getSession();
		String type=session.getAttribute("type").toString();
		
		//系统管理员密码修改
		if(type.equals("1")) {
			AdminService service = new AdminService();
			AdminInfo info = service.checkLogin(session.getAttribute("uname").toString(),pwd0);
			if(null ==	info) {
				msg= "原密码错误";
				return SUCCESS;
			}

			int flag = service.rstPwd(session.getAttribute("id").toString() , pwd1);
			if(flag > 0) 
				msg= "操作成功";
			else
				msg= "操作失败";
		//管理员密码修改
		}else if(type.equals("2")) {
			ManagerService service = new ManagerService();
			ManagerInfo info = service.checkLogin(session.getAttribute("uname").toString(),pwd0);
			if(null ==	info) {
				msg= "原密码错误";
				return SUCCESS;
			}
			
			int flag = service.rstPwd(session.getAttribute("id").toString() , pwd1);
			if(flag > 0) 
				msg= "操作成功";
			else
				msg= "操作失败";
		//学生密码修改
		}else if(type.equals("3")) {
			StudentService service = new StudentService();
			StudentInfo info = service.checkLogin(session.getAttribute("uname").toString(),pwd0);
			if(null ==	info) {
				msg= "原密码错误";
				return SUCCESS;
			}
			
			int flag = service.rstPwd(session.getAttribute("id").toString() , pwd1);
			if(flag > 0) 
				msg= "操作成功";
			else
				msg= "操作失败";
		}
		return SUCCESS;
	}
}
