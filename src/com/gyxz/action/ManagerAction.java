package com.gyxz.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gyxz.entity.ManagerInfo;
import com.gyxz.service.ManagerService;
import com.gyxz.tool.Tools;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { 
		@Result(name = "listall", location = "/ManagerList.jsp"),
		@Result(name = "doadd", location = "/ManagerAdd.jsp"),
		@Result(name = "doupdate", location = "/ManagerUpdate.jsp")
})
public class ManagerAction extends ActionSupport implements Preparable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ManagerService service = new ManagerService();
	private ManagerInfo info = new ManagerInfo();
	private ManagerInfo info_old=null;
	private String msg;
	public ManagerService getService() {
		return service;
	}
	public void setService(ManagerService service) {
		this.service = service;
	}
	public ManagerInfo getInfo() {
		return info;
	}
	public void setInfo(ManagerInfo info) {
		this.info = info;
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
		String s = ServletActionContext.getRequest().getParameter("info.id");
		if (s != null) {
			int i = Integer.parseInt(s);
			info_old = service.QueryManagerById(i);
		}
	}
	
	@Action("listManager")
	public String queryAll() {
		ServletActionContext.getRequest().setAttribute("list", service.QueryManager());
		return "listall";
	}

	@Action("addManager")		
	public String add() {
		int flag = service.addManager(info);
		Tools.returnMsg(flag , "listManager.action");
		return this.queryAll();
	}
	
	@Action("deleteManager")
	public String delete() {
		int flag = service.delManager(info.getId());
		Tools.returnMsg(flag , "listManager.action");
		return this.queryAll();
	}
	
	@Action("updateManager")
	public String update() {
		int flag =service.UpdateManager(Tools.CheckContent(info_old, info));
		Tools.returnMsg(flag , "listManager.action");
		return this.queryAll();
	}
	
	@Action("doupdateManager")
	public String queryByID() {
		ServletActionContext.getRequest().setAttribute("info", service.QueryManagerById(info.getId()));
		return "doupdate";
	}
}
