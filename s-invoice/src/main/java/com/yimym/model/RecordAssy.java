package com.yimym.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票附件
 */
@ApiModel(description = "发票附件")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class RecordAssy {
	private String id = null;

	private String recordid = null;

	private String assyid = null;

	private String assyUrl = null;

	private String assyName = null;

	private String description = null;

	private String createdBy = null;

	private Date createdAt = null;

	private String modifiedBy = null;

	private Date modifiedAt = null;

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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RecordAssy recordAssy = (RecordAssy) o;
		return Objects.equals(this.id, recordAssy.id) && Objects.equals(this.recordid, recordAssy.recordid)
				&& Objects.equals(this.assyid, recordAssy.assyid) && Objects.equals(this.assyUrl, recordAssy.assyUrl)
				&& Objects.equals(this.assyName, recordAssy.assyName)
				&& Objects.equals(this.description, recordAssy.description)
				&& Objects.equals(this.createdBy, recordAssy.createdBy)
				&& Objects.equals(this.createdAt, recordAssy.createdAt)
				&& Objects.equals(this.modifiedBy, recordAssy.modifiedBy)
				&& Objects.equals(this.modifiedAt, recordAssy.modifiedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, recordid, assyid, assyUrl, assyName, description, createdBy, createdAt, modifiedBy,
				modifiedAt);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RecordAssy {\n");

		sb.append(" id: ").append(id).append("\n");
		sb.append(" recordid: ").append(recordid).append("\n");
		sb.append(" assyid: ").append(assyid).append("\n");
		sb.append(" assyUrl: ").append(assyUrl).append("\n");
		sb.append(" assyName: ").append(assyName).append("\n");
		sb.append(" description: ").append(description).append("\n");
		sb.append(" createdBy: ").append(createdBy).append("\n");
		sb.append(" createdAt: ").append(createdAt).append("\n");
		sb.append(" modifiedBy: ").append(modifiedBy).append("\n");
		sb.append(" modifiedAt: ").append(modifiedAt).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
