package com.yimym.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票明细
 */
@ApiModel(description = "发票明细")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class RecordItem {
	private String id = null;

	private String recordid = null;

	private String itemCode = null;

	private String itemName = null;

	private String spec = null;

	private String orderitemNum = null;

	private String itemNum = null;

	private String unit = null;

	private String plusDutyPrice = null;

	private String price = null;

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

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RecordItem recordItem = (RecordItem) o;
		return Objects.equals(this.id, recordItem.id) && Objects.equals(this.recordid, recordItem.recordid)
				&& Objects.equals(this.itemCode, recordItem.itemCode)
				&& Objects.equals(this.itemName, recordItem.itemName) && Objects.equals(this.spec, recordItem.spec)
				&& Objects.equals(this.orderitemNum, recordItem.orderitemNum)
				&& Objects.equals(this.itemNum, recordItem.itemNum) && Objects.equals(this.unit, recordItem.unit)
				&& Objects.equals(this.plusDutyPrice, recordItem.plusDutyPrice)
				&& Objects.equals(this.price, recordItem.price) && Objects.equals(this.remark, recordItem.remark)
				&& Objects.equals(this.createdBy, recordItem.createdBy)
				&& Objects.equals(this.createdAt, recordItem.createdAt)
				&& Objects.equals(this.modifiedBy, recordItem.modifiedBy)
				&& Objects.equals(this.modifiedAt, recordItem.modifiedAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, recordid, itemCode, itemName, spec, orderitemNum, itemNum, unit, plusDutyPrice, price,
				remark, createdBy, createdAt, modifiedBy, modifiedAt);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RecordItem {\n");

		sb.append("    id: ").append(id).append("\n");
		sb.append("    recordid: ").append(recordid).append("\n");
		sb.append("    itemCode: ").append(itemCode).append("\n");
		sb.append("    itemName: ").append(itemName).append("\n");
		sb.append("    spec: ").append(spec).append("\n");
		sb.append("    orderitemNum: ").append(orderitemNum).append("\n");
		sb.append("    itemNum: ").append(itemNum).append("\n");
		sb.append("    unit: ").append(unit).append("\n");
		sb.append("    plusDutyPrice: ").append(plusDutyPrice).append("\n");
		sb.append("    price: ").append(price).append("\n");
		sb.append("    remark: ").append(remark).append("\n");
		sb.append("    createdBy: ").append(createdBy).append("\n");
		sb.append("    createdAt: ").append(createdAt).append("\n");
		sb.append("    modifiedBy: ").append(modifiedBy).append("\n");
		sb.append("    modifiedAt: ").append(modifiedAt).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
