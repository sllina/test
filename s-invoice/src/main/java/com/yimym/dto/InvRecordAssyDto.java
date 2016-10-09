package com.yimym.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;
@Entity
@Table(name = "invrecord_assy")
public class InvRecordAssyDto {
	@Id
	@Column(length = 50)
	private String id = null;
	@Column(length = 50)
	private String recordid = null;
	@Column(length = 50)
	private String assyid = null;
	@Column(length = 150)
	private String assyUrl = null;
	@Column(length = 200)
	private String assyName = null;
	@Column(length = 255)
	private String description = null;
	@Column(length = 50)
	private String createdBy = null;

	private Date createdAt = null;
	@Column(length = 50)
	private String modifiedBy = null;
	private Date modifiedAt = null;
	@Column(length = 10)
	@JsonIgnore
	private String status = null;
	@JsonIgnore
	private String reserved1 = null;
	@JsonIgnore
	private String reserved2 = null;
	@JsonIgnore
	private String reserved3 = null;
	@JsonIgnore
	private String reserved4 = null;
	@JsonIgnore
	private String reserved5 = null;
	@JsonIgnore
	private String reserved6 = null;
	@JsonIgnore
	private String reserved7 = null;
	@JsonIgnore
	private String reserved8 = null;

	/**
	 * id，后台自动设定，不需填写
	 * 
	 * @return id
	 **/
	@ApiModelProperty(value = "id，后台自动设定，不需填写")
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 发票记录id
	 * 
	 * @return recordid
	 **/
	@ApiModelProperty(value = "发票记录id")
	@JsonProperty("recordid")
	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}


	/**
	 * 附件id
	 * 
	 * @return assyid
	 **/
	@ApiModelProperty(value = "附件id")
	@JsonProperty("assyid")
	public String getAssyid() {
		return assyid;
	}

	public void setAssyid(String assyid) {
		this.assyid = assyid;
	}

	/**
	 * 附件地址
	 * 
	 * @return assyUrl
	 **/
	@ApiModelProperty(value = "附件地址")
	@JsonProperty("assyUrl")
	public String getAssyUrl() {
		return assyUrl;
	}

	public void setAssyUrl(String assyUrl) {
		this.assyUrl = assyUrl;
	}

	/**
	 * 附件名称
	 * 
	 * @return assyName
	 **/
	@ApiModelProperty(value = "附件名称")
	@JsonProperty("assyName")
	public String getAssyName() {
		return assyName;
	}

	public void setAssyName(String assyName) {
		this.assyName = assyName;
	}

	/**
	 * 附件描述
	 * 
	 * @return description
	 **/
	@ApiModelProperty(value = "附件描述")
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 创建者
	 * 
	 * @return createdBy
	 **/
	@ApiModelProperty(value = "创建者")
	@JsonProperty("createdBy")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * 创建时间，自动设定，不需填写
	 * 
	 * @return createdAt
	 **/
	@ApiModelProperty(value = "创建时间，自动设定，不需填写")
	@JsonProperty("createdAt")
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * 修改者
	 * 
	 * @return modifiedBy
	 **/
	@ApiModelProperty(value = "修改者")
	@JsonProperty("modifiedBy")
	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * 修改时间，自动设定，不需填写
	 * 
	 * @return modifiedAt
	 **/
	@ApiModelProperty(value = "修改时间，自动设定，不需填写")
	@JsonProperty("modifiedAt")
	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReserved1() {
		return reserved1;
	}

	public void setReserved1(String reserved1) {
		this.reserved1 = reserved1;
	}

	public String getReserved2() {
		return reserved2;
	}

	public void setReserved2(String reserved2) {
		this.reserved2 = reserved2;
	}

	public String getReserved3() {
		return reserved3;
	}

	public void setReserved3(String reserved3) {
		this.reserved3 = reserved3;
	}

	public String getReserved4() {
		return reserved4;
	}

	public void setReserved4(String reserved4) {
		this.reserved4 = reserved4;
	}

	public String getReserved5() {
		return reserved5;
	}

	public void setReserved5(String reserved5) {
		this.reserved5 = reserved5;
	}

	public String getReserved6() {
		return reserved6;
	}

	public void setReserved6(String reserved6) {
		this.reserved6 = reserved6;
	}

	public String getReserved7() {
		return reserved7;
	}

	public void setReserved7(String reserved7) {
		this.reserved7 = reserved7;
	}

	public String getReserved8() {
		return reserved8;
	}

	public void setReserved8(String reserved8) {
		this.reserved8 = reserved8;
	}

}
