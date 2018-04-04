package com.gyxz.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.gyxz.entity.BuildInfo;
import com.gyxz.entity.DormitoryInfo;
import com.gyxz.entity.StuInInfo;
import com.gyxz.entity.StudentInfo;
import com.gyxz.service.BuildService;
import com.gyxz.service.DormitoryService;
import com.gyxz.service.StuDorService;
import com.gyxz.service.StudentService;
import com.gyxz.tool.Tools;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

@ParentPackage("struts-default")
@Namespace("/")
@Results(value = { 
		@Result(name = "dostuInRecord", location = "/StuIn.jsp") ,
		@Result(name = "stuInRecord", location = "/StuIn.jsp") 
})
public class StuInAction extends ActionSupport implements Preparable {
	private static final long serialVersionUID = 1L;

	private List<BuildInfo> blist = new ArrayList<BuildInfo>();
	private List<DormitoryInfo> dlist = new ArrayList<DormitoryInfo>();

	private StuInInfo info = new StuInInfo();
	private String msg;
	
	public StuInInfo getInfo() {
		return info;
	}

	public void setInfo(StuInInfo info) {
		this.info = info;
	}

	@Override
	public void prepare() throws Exception {
		Tools.checkSession();

	}

	@Action("dostuInRecord")
	public String queryDormitoryByBid() {
		blist = new BuildService().QueryBuild();
		if (null != info.getB_id())
			dlist = new DormitoryService().QueryDormitoryByBid(info.getB_id().toString());
		return "dostuInRecord";
	}

	@Action("stuInRecord")
	public String stuInRecord() {
		StudentInfo sinfo=new StudentService().QueryStudentById(info.getS_id());
		DormitoryInfo dinfo =new DormitoryService().QueryDormitoryById(info.getD_id());
		BuildInfo binfo = new BuildService().QueryBuildById(info.getB_id());
		if(new  StuDorService().QueryInInfoById(sinfo.getId())!=null) {
			msg="操作失败,此学生已经入住";
			return "dostuInRecord";
		}
		if(sinfo.getSsex().equals(binfo.getBtype())) {
			int flag = new StuDorService().addStuIn(info);
			Tools.returnMsg(flag, "dostuInRecord.action");
			//学生状态变化
			sinfo.setState(1);
			new StudentService().UpdateStudent(sinfo);
			//宿舍人数变化
			dinfo.setScount(dinfo.getScount()+1);
			new DormitoryService().UpdateDormitory(dinfo);
			msg="操作成功";
			return "stuInRecord";
		}else
			msg="操作失败,学生性别与对应宿舍不相符";
		return "dostuInRecord";
	}
	
	public List<BuildInfo> getBlist() {
		return blist;
	}

	public void setBlist(List<BuildInfo> blist) {
		this.blist = blist;
	}

	public List<DormitoryInfo> getDlist() {
		return dlist;
	}

	public void setDlist(List<DormitoryInfo> dlist) {
		this.dlist = dlist;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
