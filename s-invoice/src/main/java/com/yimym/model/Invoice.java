package com.yimym.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票
 **/
@ApiModel(description = "发票")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class Invoice {
	private String id = null;

	private String orderid = null;

	private String turnOver = null;

	private String invoicePrice = null;

	private String orderCode = null;

	private String clientid = null;

	private String clientFullName = null;

	private String orderMakerid = null;

	private String orderMakerName = null;

	private String invoiceStatus = null;

	private String remark = null;

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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Invoice invoice = (Invoice) o;
		return Objects.equals(this.id, invoice.id) && Objects.equals(this.orderid, invoice.orderid)
				&& Objects.equals(this.turnOver, invoice.turnOver)
				&& Objects.equals(this.invoicePrice, invoice.invoicePrice)
				&& Objects.equals(this.orderCode, invoice.orderCode) && Objects.equals(this.clientid, invoice.clientid)
				&& Objects.equals(this.clientFullName, invoice.clientFullName)
				&& Objects.equals(this.orderMakerid, invoice.orderMakerid)
				&& Objects.equals(this.orderMakerName, invoice.orderMakerName)
				&& Objects.equals(this.invoiceStatus, invoice.invoiceStatus)
				&& Objects.equals(this.remark, invoice.remark) && Objects.equals(this.createdBy, invoice.createdBy)
				&& Objects.equals(this.createdAt, invoice.createdAt)
				&& Objects.equals(this.modifiedBy, invoice.modifiedBy)
				&& Objects.equals(this.modifiedAt, invoice.modifiedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, orderid, turnOver, invoicePrice, orderCode, clientid, clientFullName, orderMakerid,
				orderMakerName, invoiceStatus, remark, createdBy, createdAt, modifiedBy, modifiedAt);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Invoice {\n");
		sb.append(" id: ").append(id).append("\n");
		sb.append(" orderid: ").append(orderid).append("\n");
		sb.append(" turnOver: ").append(turnOver).append("\n");
		sb.append(" invoicePrice: ").append(invoicePrice).append("\n");
		sb.append(" orderCode: ").append(orderCode).append("\n");
		sb.append(" clientid: ").append(clientid).append("\n");
		sb.append(" clientFullName: ").append(clientFullName).append("\n");
		sb.append(" orderMakerid: ").append(orderMakerid).append("\n");
		sb.append(" orderMakerName: ").append(orderMakerName).append("\n");
		sb.append(" invoiceStatus: ").append(invoiceStatus).append("\n");
		sb.append(" remark: ").append(remark).append("\n");
		sb.append(" createdBy: ").append(createdBy).append("\n");
		sb.append(" createdAt: ").append(createdAt).append("\n");
		sb.append(" modifiedBy: ").append(modifiedBy).append("\n");
		sb.append(" modifiedAt: ").append(modifiedAt).append("\n");
		sb.append("}\n");
		return sb.toString();
	}

}
