package com.gyxz.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gyxz.entity.BuildInfo;
import com.gyxz.service.BuildService;
import com.gyxz.tool.Tools;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { @Result(name = "listall", location = "/BuildList.jsp"),
		@Result(name = "doadd", location = "/BuildAdd.jsp"),
		@Result(name = "doupdate", location = "/BuildUpdate.jsp")
})
public class BuildAction extends ActionSupport implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BuildService service = new BuildService();
	private BuildInfo info = new BuildInfo();
	private BuildInfo info_old = null;
	private String msg;

	@Override
	public void prepare() throws Exception {
		Tools.checkSession();
		String s = ServletActionContext.getRequest().getParameter("info.id");
		if (s != null) {
			int i = Integer.parseInt(s);
			info_old = service.QueryBuildById(i);
		}
	}

	@Action("listBuild")
	public String queryAll() {
		ServletActionContext.getRequest().setAttribute("list", service.QueryBuild());
		return "listall";
	}

	@Action("addBuild")
	public String add() {
		int flag = service.addBuild(info);
		Tools.returnMsg(flag, "listBuild.action");
		return this.queryAll();
	}

	@Action("deleteBuild")
	public String delete() {
		int flag = service.delBuild(info.getId());
		Tools.returnMsg(flag, "listBuild.action");
		return this.queryAll();
	}

	@Action("updateBuild")
	public String update() {
		int flag = service.UpdateBuild(Tools.CheckContent(info_old, info));
		Tools.returnMsg(flag, "listBuild.action");
		return this.queryAll();
	}

	@Action("doupdateBuild")
	public String queryByID() {
		ServletActionContext.getRequest().setAttribute("info", service.QueryBuildById(info.getId()));
		return "doupdate";
	}
	//get set
	public BuildService getService() {
		return service;
	}

	public void setService(BuildService service) {
		this.service = service;
	}

	public BuildInfo getInfo() {
		return info;
	}

	public void setInfo(BuildInfo info) {
		this.info = info;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
