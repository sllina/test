package com.yimym.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;




/**
 * Process
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class Process   {
	private String id;
	private String procstatus;
	private String objid;
	private String objtype1;
	private String objtype2;
	private String objname;
	private String deptid;
	private String deptname;
	private String createdBy;
	private Date createdAt;
	private String modifiedBy;
	private Date modifiedAt;
	private Date finishedAt;
	private String remark;

	@ApiModelProperty(value = "修改者")
	@JsonProperty("modifiedBy")
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	@ApiModelProperty(value = "修改时间，自动设定，不需填写")
	@JsonProperty("modifiedAt")
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@ApiModelProperty(value = "流程完成时间")
	@JsonProperty("finishedAt")
	public Date getFinishedAt() {
		return finishedAt;
	}

	public void setFinishedAt(Date finishedAt) {
		this.finishedAt = finishedAt;
	}

	@ApiModelProperty(value = "备注")
	@JsonProperty("remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@ApiModelProperty(value = "流程对象ID")
	@JsonProperty("objid")
	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

	@ApiModelProperty(value = "流程对象类型1")
	@JsonProperty("objtype1")
	public String getObjtype1() {
		return objtype1;
	}

	public void setObjtype1(String objtype1) {
		this.objtype1 = objtype1;
	}

	@ApiModelProperty(value = "流程对象类型2")
	@JsonProperty("objtype2")
	public String getObjtype2() {
		return objtype2;
	}

	public void setObjtype2(String objtype2) {
		this.objtype2 = objtype2;
	}

	@ApiModelProperty(value = "流程对象名称")
	@JsonProperty("objname")
	public String getObjname() {
		return objname;
	}

	public void setObjname(String objname) {
		this.objname = objname;
	}

	@ApiModelProperty(value = "所属部门ID")
	@JsonProperty("deptid")
	public String getDeptid() {
		return deptid;
	}

	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}

	@ApiModelProperty(value = "创建者")
	@JsonProperty("createdBy")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@ApiModelProperty(value = "创建时间，自动设定，不需填写")
	@JsonProperty("createdAt")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@ApiModelProperty(value = "id，后台自动设定，不需填写")
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ApiModelProperty(value = "所属部门名称")
	@JsonProperty("deptname")
	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	@ApiModelProperty(value = "流程状态")
	@JsonProperty("procstatus")
	public String getProcstatus() {
		return procstatus;
	}

	public void setProcstatus(String procstatus) {
		this.procstatus = procstatus;
	}
}

