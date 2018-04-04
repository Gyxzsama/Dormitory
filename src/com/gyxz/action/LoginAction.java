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
import com.opensymphony.xwork2.ActionSupport;

@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { 
		@Result(name = "success", location = "/Index.jsp"),
		@Result(name = "reinput", location = "/Login.jsp") 
})
public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 用户名密码
	private String uname;
	private String pwd;
	// 管理员类型
	private String select;
	private String msg;
	private String type;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Action("dologin")
	public String checkLogin() {
		// 系统管理员
		if (select.equals("1")) {
			AdminService service = new AdminService();
			AdminInfo info = service.checkLogin(uname, pwd);
			if (null == info) {
				msg = "账号或者密码错误";
				return "reinput";
			} else {
				HttpSession session = ServletActionContext.getRequest().getSession();

				session.setAttribute("uname", info.getAuname());
				session.setAttribute("name", info.getAname());
				session.setAttribute("id", info.getId());
				session.setAttribute("type", "1");
				return SUCCESS;
			}
			// 管理员
		} else if (select.equals("2")) {
			ManagerService service = new ManagerService();
			ManagerInfo info = service.checkLogin(uname, pwd);
			if (null == info) {
				msg = "账号或者密码错误";
				return "reinput";
			} else {
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("uname", info.getMuname());
				session.setAttribute("name", info.getMname());
				session.setAttribute("id", info.getId());
				session.setAttribute("type", "2");
				return SUCCESS;
			}
			// 学生
		} else if (select.equals("3")) {
			StudentService service = new StudentService();
			StudentInfo info = service.checkLogin(uname, pwd);
			if (null == info) {
				msg = "账号或者密码错误";
				return "reinput";
			} else {
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.setAttribute("uname", info.getSuname());
				session.setAttribute("name", info.getSname());
				session.setAttribute("id", info.getId());
				session.setAttribute("type", "3");
				return SUCCESS;
			}
		}
		return "reinput";
	}
}
