package com.gyxz.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gyxz.entity.DormitoryInfo;
import com.gyxz.entity.StuInInfo;
import com.gyxz.entity.StuOutInfo;
import com.gyxz.entity.StudentInfo;
import com.gyxz.service.DormitoryService;
import com.gyxz.service.StuDorService;
import com.gyxz.service.StudentService;
import com.gyxz.tool.Tools;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { 
		@Result(name = "success", location = "/StuOut2.jsp") ,
		@Result(name = "doStuOut", location = "/StuOut.jsp") ,
		@Result(name = "listStuOut", location = "/StuOutList.jsp") 
		
})
public class StuOutAction extends ActionSupport implements Preparable{

	private static final long serialVersionUID = 1L;
	private StudentInfo sinfo = new StudentInfo();
	private StuInInfo ininfo = new StuInInfo();
	private DormitoryInfo dinfo = new DormitoryInfo();
	private List<StuOutInfo> list = new ArrayList<StuOutInfo>();
	private String remarks;
	private String msg;
	@Override
	public void prepare() throws Exception {
		Tools.checkSession();
	}
	
	@Action("doStuOut")
	public String doStuOut() {
		sinfo = new StudentService().QueryStudentById(sinfo.getId());
		ininfo = new StuDorService().QueryInInfoById(sinfo.getId());
		if(ininfo==null) {
			msg="此学生未入住";
			return "doStuOut";
		}
		dinfo = new DormitoryService().QueryDormitoryById(ininfo.getD_id());
		return SUCCESS;
	}
	
	@Action("StuOut")
	public String StuOut() {
		sinfo = new StudentService().QueryStudentById(sinfo.getId());
		ininfo = new StuDorService().QueryInInfoById(sinfo.getId());
		dinfo = new DormitoryService().QueryDormitoryById(ininfo.getD_id());
		//删in
		new StuDorService().delete(ininfo.getId());
		//改状态
		sinfo.setState(2);
		new StudentService().UpdateStudent(sinfo);
		//宿舍人数变化
		dinfo.setScount(dinfo.getScount()-1);
		new DormitoryService().UpdateDormitory(dinfo);
		//加OUT
		new StuDorService().addStuOut(ininfo,remarks);
		
		msg="操作成功";
		return SUCCESS;
	}

	@Action("listStuOut")
	public String listStuOut() {
		list=new StuDorService().QueryOutInfo(); 
		return "listStuOut";
	}
	
	
	
	
	public StudentInfo getSinfo() {
		return sinfo;
	}

	public void setSinfo(StudentInfo sinfo) {
		this.sinfo = sinfo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public StuInInfo getIninfo() {
		return ininfo;
	}

	public void setIninfo(StuInInfo ininfo) {
		this.ininfo = ininfo;
	}

	public DormitoryInfo getDinfo() {
		return dinfo;
	}

	public void setDinfo(DormitoryInfo dinfo) {
		this.dinfo = dinfo;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public List<StuOutInfo> getList() {
		return list;
	}

	public void setList(List<StuOutInfo> list) {
		this.list = list;
	}
	

}
