package com.gyxz.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gyxz.entity.StudentInfo;
import com.gyxz.service.StudentService;
import com.gyxz.tool.Tools;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;


@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { 
		@Result(name = "reinput", location = "/Login.jsp"),
		@Result(name = "listall", location = "/StudentList.jsp"),
		@Result(name = "doadd", location = "/StudentAdd.jsp"),
		@Result(name = "doupdate", location = "/StudentUpdate.jsp")
})
public class StudentAction extends ActionSupport implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StudentService service = new StudentService();
	private StudentInfo info = new StudentInfo();
	private StudentInfo info_old = null;
	private String msg;
	


	@Override
	public void prepare() throws Exception {
		Tools.checkSession();
		String s = ServletActionContext.getRequest().getParameter("info.id");
		if (s != null) {
			int i = Integer.parseInt(s);
			info_old = service.QueryStudentById(i);
		}
	}
	
	@Action("listStudent")
	public String queryAll() {
		ServletActionContext.getRequest().setAttribute("list", service.QueryStudent());
		return "listall";
	}

	@Action("addStudent")		
	public String add() {
		int flag = service.addStudent(info);
		Tools.returnMsg(flag , "listStudent.action");
		return this.queryAll();
	}
	
	@Action("deleteStudent")
	public String delete() {
		int flag = service.delStudent(info.getId());
		Tools.returnMsg(flag , "listStudent.action");
		return this.queryAll();
	}
	
	@Action("updateStudent")
	public String update() {
		int flag =service.UpdateStudent(Tools.CheckContent(info_old, info));
		Tools.returnMsg(flag , "listStudent.action");
		return this.queryAll();
	}
	
	@Action("doupdateStudent")
	public String queryByID() {
		ServletActionContext.getRequest().setAttribute("info", service.QueryStudentById(info.getId()));
		return "doupdate";
	}
	
	//get set
	public StudentService getService() {
		return service;
	}
	public void setService(StudentService service) {
		this.service = service;
	}
	public StudentInfo getInfo() {
		return info;
	}
	public void setInfo(StudentInfo info) {
		this.info = info;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
