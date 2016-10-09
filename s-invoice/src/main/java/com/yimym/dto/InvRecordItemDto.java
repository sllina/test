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
@Table(name = "invrecord_item")
public class InvRecordItemDto {
	@Id
	@Column(length = 50)
	private String id = null;
	@Column(length = 50)
	private String recordid = null;
	@Column(length = 150)
	private String itemCode = null;
	@Column(length = 150)
	private String itemName = null;
	@Column(length = 100)
	private String spec = null;
	@Column(length = 50)
	private String orderitemNum = null;
	@Column(length = 50)
	private String itemNum = null;
	@Column(length = 50)
	private String unit = null;
	@Column(length = 50)
	private String plusDutyPrice = null;
	@Column(length = 50)
	private String price = null;
	private String remark = null;
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
	 * 产品编号
	 * 
	 * @return itemCode
	 **/
	@ApiModelProperty(value = "产品编号")
	@JsonProperty("itemCode")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * 产品名称
	 * 
	 * @return itemName
	 **/
	@ApiModelProperty(value = "产品名称")
	@JsonProperty("itemName")
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	/**
	 * 规格
	 * 
	 * @return spec
	 **/
	@ApiModelProperty(value = "规格")
	@JsonProperty("spec")
	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	/**
	 * 订单项数量
	 * 
	 * @return orderitemNum
	 **/
	@ApiModelProperty(value = "订单项数量")
	@JsonProperty("orderitemNum")
	public String getOrderitemNum() {
		return orderitemNum;
	}

	public void setOrderitemNum(String orderitemNum) {
		this.orderitemNum = orderitemNum;
	}

	/**
	 * 发票明细数量
	 * 
	 * @return itemNum
	 **/
	@ApiModelProperty(value = "发票明细数量")
	@JsonProperty("itemNum")
	public String getItemNum() {
		return itemNum;
	}

	public void setItemNum(String itemNum) {
		this.itemNum = itemNum;
	}

	/**
	 * 单位
	 * 
	 * @return unit
	 **/
	@ApiModelProperty(value = "单位")
	@JsonProperty("unit")
	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * 含税单价
	 * 
	 * @return plusDutyPrice
	 **/
	@ApiModelProperty(value = "含税单价")
	@JsonProperty("plusDutyPrice")
	public String getPlusDutyPrice() {
		return plusDutyPrice;
	}

	public void setPlusDutyPrice(String plusDutyPrice) {
		this.plusDutyPrice = plusDutyPrice;
	}

	/**
	 * 金额
	 * 
	 * @return price
	 **/
	@ApiModelProperty(value = "金额")
	@JsonProperty("price")
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * 备注
	 * 
	 * @return remark
	 **/
	@ApiModelProperty(value = "备注")
	@JsonProperty("remark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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
