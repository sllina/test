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
@Table(name = "invoice_info")
public class InvoiceDto {
	@Id
	@Column(length = 50)
	private String id = null;
	@Column(length = 50)
	private String orderid = null;
	@Column(length = 50)
	private String turnOver = null;
	@Column(length = 50)
	private String invoicePrice = null;
	@Column(length = 150)
	private String orderCode = null;
	@Column(length = 50)
	private String clientid = null;
	@Column(length = 150)
	private String clientFullName = null;
	@Column(length = 50)
	private String orderMakerid = null;
	@Column(length = 150)
	private String orderMakerName = null;
	@Column(length = 10)
	private String invoiceStatus = null;

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
	 * 订单id
	 * 
	 * @return orderid
	 **/
	@ApiModelProperty(value = "订单id")
	@JsonProperty("orderid")
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	/**
	 * 订单成交价
	 * 
	 * @return turnOver
	 **/
	@ApiModelProperty(value = "订单成交价")
	@JsonProperty("turnOver")
	public String getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(String turnOver) {
		this.turnOver = turnOver;
	}

	/**
	 * 已开票金额
	 * 
	 * @return invoicePrice
	 **/
	@ApiModelProperty(value = "已开票金额")
	@JsonProperty("invoicePrice")
	public String getInvoicePrice() {
		return invoicePrice;
	}

	public void setInvoicePrice(String invoicePrice) {
		this.invoicePrice = invoicePrice;
	}

	/**
	 * 订单编号
	 * 
	 * @return orderCode
	 **/
	@ApiModelProperty(value = "订单编号")
	@JsonProperty("orderCode")
	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}


	/**
	 * 订单客户id
	 * 
	 * @return clientid
	 **/
	@ApiModelProperty(value = "订单客户id")
	@JsonProperty("clientid")
	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	/**
	 * 订单客户名称
	 * 
	 * @return clientFullName
	 **/
	@ApiModelProperty(value = "订单客户名称")
	@JsonProperty("clientFullName")
	public String getClientFullName() {
		return clientFullName;
	}

	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}

	/**
	 * 订单销售人员id
	 * 
	 * @return orderMakerid
	 **/
	@ApiModelProperty(value = "订单销售人员id")
	@JsonProperty("orderMakerid")
	public String getOrderMakerid() {
		return orderMakerid;
	}

	public void setOrderMakerid(String orderMakerid) {
		this.orderMakerid = orderMakerid;
	}

	/**
	 * 订单销售人员姓名
	 * 
	 * @return orderMakerName
	 **/
	@ApiModelProperty(value = "订单销售人员姓名")
	@JsonProperty("orderMakerName")
	public String getOrderMakerName() {
		return orderMakerName;
	}

	public void setOrderMakerName(String orderMakerName) {
		this.orderMakerName = orderMakerName;
	}

	/**
	 * 开票状态
	 * 
	 * @return invoiceStatus
	 **/
	@ApiModelProperty(value = "开票状态,新增和修改时不需要填写，专门提供修改状态的接口")
	@JsonProperty("invoiceStatus")
	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
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
