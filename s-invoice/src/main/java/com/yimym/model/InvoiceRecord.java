package com.yimym.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票记录
 **/

/**
 * 发票记录
 */
@ApiModel(description = "发票记录")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")
public class InvoiceRecord {
	private String id = null;

	private String invoiceid = null;

	private String recordCode = null;

	private String orderCode = null;

	private String dutyNumber = null;

	private String clientFullName = null;

	private String clientAddress = null;

	private String phone = null;

	private String clientBankFullName = null;

	private String clientBankAccount = null;

	private String subInvoicePrice = null;

	private String invoiceType = null;

	private String taxRate = null;

	private String recordStatus = null;

	private String remark = null;

	private String createdBy = null;
	
	private String createdByName = null;

	private Date createdAt = null;

	private String modifiedBy = null;
	
	private String modifiedByName = null;

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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InvoiceRecord invoiceRecord = (InvoiceRecord) o;
		return Objects.equals(this.id, invoiceRecord.id) && Objects.equals(this.invoiceid, invoiceRecord.invoiceid)
				&& Objects.equals(this.recordCode, invoiceRecord.recordCode)
				&& Objects.equals(this.orderCode, invoiceRecord.orderCode)
				&& Objects.equals(this.dutyNumber, invoiceRecord.dutyNumber)
				&& Objects.equals(this.clientFullName, invoiceRecord.clientFullName)
				&& Objects.equals(this.clientAddress, invoiceRecord.clientAddress)
				&& Objects.equals(this.phone, invoiceRecord.phone)
				&& Objects.equals(this.clientBankFullName, invoiceRecord.clientBankFullName)
				&& Objects.equals(this.clientBankAccount, invoiceRecord.clientBankAccount)
				&& Objects.equals(this.subInvoicePrice, invoiceRecord.subInvoicePrice)
				&& Objects.equals(this.invoiceType, invoiceRecord.invoiceType)
				&& Objects.equals(this.taxRate, invoiceRecord.taxRate)
				&& Objects.equals(this.recordStatus, invoiceRecord.recordStatus)
				&& Objects.equals(this.remark, invoiceRecord.remark)
				&& Objects.equals(this.createdBy, invoiceRecord.createdBy)
				&& Objects.equals(this.createdAt, invoiceRecord.createdAt)
				&& Objects.equals(this.modifiedBy, invoiceRecord.modifiedBy)
				&& Objects.equals(this.modifiedAt, invoiceRecord.modifiedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, invoiceid, recordCode, orderCode, dutyNumber, clientFullName, clientAddress, phone,
				clientBankFullName, clientBankAccount, subInvoicePrice, invoiceType, taxRate, recordStatus, remark,
				createdBy, createdAt, modifiedBy, modifiedAt);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InvoiceRecord {\n");

		sb.append(" id: ").append(id).append("\n");
		sb.append(" invoiceid: ").append(invoiceid).append("\n");
		sb.append(" recordCode: ").append(recordCode).append("\n");
		sb.append(" orderCode: ").append(orderCode).append("\n");
		sb.append(" dutyNumber: ").append(dutyNumber).append("\n");
		sb.append(" clientFullName: ").append(clientFullName).append("\n");
		sb.append(" clientAddress: ").append(clientAddress).append("\n");
		sb.append(" phone: ").append(phone).append("\n");
		sb.append(" clientBankFullName: ").append(clientBankFullName).append("\n");
		sb.append(" clientBankAccount: ").append(clientBankAccount).append("\n");
		sb.append(" subInvoicePrice: ").append(subInvoicePrice).append("\n");
		sb.append(" invoiceType: ").append(invoiceType).append("\n");
		sb.append(" taxRate: ").append(taxRate).append("\n");
		sb.append(" recordStatus: ").append(recordStatus).append("\n");
		sb.append(" remark: ").append(remark).append("\n");
		sb.append(" createdBy: ").append(createdBy).append("\n");
		sb.append(" createdAt: ").append(createdAt).append("\n");
		sb.append(" modifiedBy: ").append(modifiedBy).append("\n");
		sb.append(" modifiedAt: ").append(modifiedAt).append("\n");
		sb.append("}\n");
		return sb.toString();
	}

}
