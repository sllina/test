package com.yimym.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "流程任务模型")
public class Task {
	private String id;
	private String taskstatus;
	private String pid;
	private String procid;
	private String empid;
	private String empname;
	private String deptid;
	private String deptname;
	private Date createdAt;
	private Date acceptedAt;
	private Date finishedAt;
	private String comments;
	private String remark;

	@ApiModelProperty(value = "id，后台自动设定，不需填写")
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ApiModelProperty(value = "任务状态")
	@JsonProperty("taskstatus")
	public String getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}

	@ApiModelProperty(value = "上一站任务ID，初次建立为-1")
	@JsonProperty("pid")
	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	@ApiModelProperty(value = "任务所属流程")
	@JsonProperty("procid")
	public String getProcid() {
		return procid;
	}

	public void setProcid(String procid) {
		this.procid = procid;
	}

	@ApiModelProperty(value = "任务所属员工ID")
	@JsonProperty("empid")
	public String getEmpid() {
		return empid;
	}

	public void setEmpid(String empid) {
		this.empid = empid;
	}

	@ApiModelProperty(value = "所属员工名称")
	@JsonProperty("empname")
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	@ApiModelProperty(value = "所属部门名称")
	@JsonProperty("deptname")
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@ApiModelProperty(value = "任务所属部门ID")
	@JsonProperty("deptid")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@ApiModelProperty(value = "创建时间，自动生成，无需填写")
	@JsonProperty("createdAt")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@ApiModelProperty(value = "任务接受时间")
	@JsonProperty("acceptedAt")
	public Date getAcceptedAt() {
		return acceptedAt;
	}

	public void setAcceptedAt(Date acceptedAt) {
		this.acceptedAt = acceptedAt;
	}

	@ApiModelProperty(value = "任务完成时间")
	@JsonProperty("finishedAt")
	public Date getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	@ApiModelProperty(value = "任务意见")
	@JsonProperty("comments")
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@ApiModelProperty(value = "任务备注")
	@JsonProperty("remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
