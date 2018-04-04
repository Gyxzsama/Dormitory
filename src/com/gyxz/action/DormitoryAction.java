package com.gyxz.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gyxz.entity.BuildInfo;
import com.gyxz.entity.DormitoryInfo;
import com.gyxz.service.BuildService;
import com.gyxz.service.DormitoryService;
import com.gyxz.tool.Tools;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { 
		@Result(name = "listall", location = "/DormitoryList.jsp"),
		@Result(name = "doadd", location = "/DormitoryAdd.jsp"),
		@Result(name = "doupdate", location = "/DormitoryUpdate.jsp")
})
public class DormitoryAction  extends ActionSupport implements Preparable{
	
	private static final long serialVersionUID = 1L;
	
	private DormitoryService service = new DormitoryService();
	private DormitoryInfo info = new DormitoryInfo();
	private DormitoryInfo info_old=null;
	
	private List<BuildInfo> blist=null; 
	private String msg;
	
	@Override
	public void prepare() throws Exception {
		Tools.checkSession();
		String s = ServletActionContext.getRequest().getParameter("info.id");
		if (s != null) {
			int i = Integer.parseInt(s);
			info_old = service.QueryDormitoryById(i);
		}
	}
	
	@Action("listDormitory")
	public String queryAll() {
		ServletActionContext.getRequest().setAttribute("list", service.QueryDormitory());
		return "listall";
	}
	
	@Action("doaddDormitory")		
	public String doadd() {
		blist=new BuildService().QueryBuild();
		ServletActionContext.getRequest().setAttribute("blist", new BuildService().QueryBuild());
		return "doadd";
	}
	
	@Action("addDormitory")		
	public String add() {
		int flag = service.addDormitory(info);
		Tools.returnMsg(flag , "listDormitory.action");
		return this.queryAll();
	}
	
	@Action("deleteDormitory")
	public String delete() {
		int flag = service.delDormitory(info.getId());
		Tools.returnMsg(flag , "listDormitory.action");
		return this.queryAll();
	}
	
	@Action("updateDormitory")
	public String update() {
		int flag = service.UpdateDormitory(Tools.CheckContent(info_old, info));
		Tools.returnMsg(flag , "listDormitory.action");
		return this.queryAll();
	}
	
	@Action("doupdateDormitory")
	public String queryByID() {
		info = service.QueryDormitoryById(info.getId());
		blist=new BuildService().QueryBuild();
		return "doupdate";
	}
	

	public List<BuildInfo> getBlist() {
		return blist;
	}

	public void setBlist(List<BuildInfo> blist) {
		this.blist = blist;
	}

	public DormitoryService getService() {
		return service;
	}

	public void setService(DormitoryService service) {
		this.service = service;
	}

	public DormitoryInfo getInfo() {
		return info;
	}

	public void setInfo(DormitoryInfo info) {
		this.info = info;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
