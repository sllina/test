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
@Table(name = "invoice_record")
public class InvoiceRecordDto {
	@Id
	@Column(length = 50)
	private String id = null;
	@Column(length = 50)
	private String invoiceid = null;
	@Column(length = 150)
	private String recordCode = null;
	@Column(length = 150)
	private String orderCode = null;
	@Column(length = 150)
	private String dutyNumber = null;
	@Column(length = 150)
	private String clientFullName = null;
	@Column(length = 255)
	private String clientAddress = null;
	@Column(length = 15)
	private String phone = null;
	@Column(length = 255)
	private String clientBankFullName = null;
	@Column(length = 150)
	private String clientBankAccount = null;
	@Column(length = 50)
	private String subInvoicePrice = null;
	@Column(length = 150)
	private String invoiceType = null;
	@Column(length = 100)
	private String taxRate = null;
	@Column(length = 10)
	private String recordStatus = null;

	private String remark = null;
	@Column(length = 50)
	private String createdBy = null;

	private Date createdAt = null;
	@Column(length = 50)
	private String modifiedBy = null;
	
	private String createdByName = null;
	
	private String modifiedByName = null;

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
	 * 发票id
	 * 
	 * @return invoiceid
	 **/
	@ApiModelProperty(value = "发票id")
	@JsonProperty("invoiceid")
	public String getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(String invoiceid) {
		this.invoiceid = invoiceid;
	}
	
	/**
	 * 发票记录编号
	 * 
	 * @return recordCode
	 **/
	@ApiModelProperty(value = "发票记录编号")
	@JsonProperty("recordCode")
	public String getRecordCode() {
		return recordCode;
	}

	public void setRecordCode(String recordCode) {
		this.recordCode = recordCode;
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
	 * 税号
	 * 
	 * @return dutyNumber
	 **/
	@ApiModelProperty(value = "税号")
	@JsonProperty("dutyNumber")
	public String getDutyNumber() {
		return dutyNumber;
	}

	public void setDutyNumber(String dutyNumber) {
		this.dutyNumber = dutyNumber;
	}
	
	/**
	 * 客户名称
	 * 
	 * @return clientName
	 **/
	@ApiModelProperty(value = "客户名称")
	@JsonProperty("clientFullName")
	public String getClientFullName() {
		return clientFullName;
	}

	public void setClientFullName(String clientFullName) {
		this.clientFullName = clientFullName;
	}


	/**
	 * 客户地址
	 * 
	 * @return clientAddress
	 **/
	@ApiModelProperty(value = "客户地址")
	@JsonProperty("clientAddress")
	public String getClientAddress() {
		return clientAddress;
	}

	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}

	/**
	 * 电话
	 * 
	 * @return phone
	 **/
	@ApiModelProperty(value = "电话")
	@JsonProperty("phone")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 开户行名称
	 * 
	 * @return clientBankFullName
	 **/
	@ApiModelProperty(value = "开户行名称")
	@JsonProperty("clientBankFullName")
	public String getClientBankFullName() {
		return clientBankFullName;
	}

	public void setClientBankFullName(String clientBankFullName) {
		this.clientBankFullName = clientBankFullName;
	}

	/**
	 * 开户行账号
	 * 
	 * @return clientBankAccount
	 **/
	@ApiModelProperty(value = "开户行账号")
	@JsonProperty("clientBankAccount")
	public String getClientBankAccount() {
		return clientBankAccount;
	}

	public void setClientBankAccount(String clientBankAccount) {
		this.clientBankAccount = clientBankAccount;
	}

	/**
	 * 本次开票金额
	 * 
	 * @return subInvoicePrice
	 **/
	@ApiModelProperty(value = "本次开票金额")
	@JsonProperty("subInvoicePrice")
	public String getSubInvoicePrice() {
		return subInvoicePrice;
	}

	public void setSubInvoicePrice(String subInvoicePrice) {
		this.subInvoicePrice = subInvoicePrice;
	}

	/**
	 * 发票类型
	 * 
	 * @return invoiceType
	 **/
	@ApiModelProperty(value = "发票类型")
	@JsonProperty("invoiceType")
	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	/**
	 * 税率
	 * 
	 * @return taxRate
	 **/
	@ApiModelProperty(value = "税率")
	@JsonProperty("taxRate")
	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	/**
	 * 开票记录状态
	 * 
	 * @return recordStatus
	 **/
	@ApiModelProperty(value = "开票记录状态")
	@JsonProperty("recordStatus")
	public String getRecordStatus() {
		return recordStatus;
	}

	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	/**
	 * 创建者姓名
	 * 
	 * @return createdBy
	 **/
	@ApiModelProperty(value = "创建者姓名")
	public String getCreatedByName() {
		return createdByName;
	}

	public void setCreatedByName(String createdByName) {
		this.createdByName = createdByName;
	}

	/**
	 * 审批者姓名
	 * 
	 * @return createdBy
	 **/
	@ApiModelProperty(value = "审批者姓名")
	public String getModifiedByName() {
		return modifiedByName;
	}

	public void setModifiedByName(String modifiedByName) {
		this.modifiedByName = modifiedByName;
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
