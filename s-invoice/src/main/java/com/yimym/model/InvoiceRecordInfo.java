package com.yimym.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yimym.dto.InvRecordAssyDto;
import com.yimym.dto.InvRecordItemDto;
import com.yimym.dto.InvoiceRecordDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票记录的所有信息
 **/

/**
 * 发票记录的所有信息
 */
@ApiModel(description = "发票记录的所有信息")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class InvoiceRecordInfo {
	private InvoiceRecordDto invoiceRecord = null;

	private List<InvRecordItemDto> invoiceItem = new ArrayList<InvRecordItemDto>();

	private List<InvRecordAssyDto> invoiceAssy = new ArrayList<InvRecordAssyDto>();

	private List<ProcessInfo> invoiceProcess = new ArrayList<ProcessInfo>();

	/**
	 * 发票记录
	 * 
	 * @return invoiceRecord
	 **/
	@ApiModelProperty(value = "发票记录")
	@JsonProperty("invoiceRecord")
	public InvoiceRecordDto getInvoiceRecord() {
		return invoiceRecord;
	}

	public void setInvoiceRecord(InvoiceRecordDto invoiceRecord) {
		this.invoiceRecord = invoiceRecord;
	}

	/**
	 * 发票明细
	 * 
	 * @return invoiceItem
	 **/
	@ApiModelProperty(value = "发票明细")
	@JsonProperty("invoiceItem")
	public List<InvRecordItemDto> getInvoiceItem() {
		return invoiceItem;
	}

	public void setInvoiceItem(List<InvRecordItemDto> invoiceItem) {
		this.invoiceItem = invoiceItem;
	}

	/**
	 * 发票附件
	 * 
	 * @return invoiceAssy
	 **/
	@ApiModelProperty(value = "发票附件")
	@JsonProperty("invoiceAssy")
	public List<InvRecordAssyDto> getInvoiceAssy() {
		return invoiceAssy;
	}

	public void setInvoiceAssy(List<InvRecordAssyDto> invoiceAssy) {
		this.invoiceAssy = invoiceAssy;
	}

	/**
	 * 流程信息
	 * 
	 * @return invoiceProcess
	 **/
	@ApiModelProperty(value = "流程信息")
	@JsonProperty("invoiceProcess")
	public List<ProcessInfo> getInvoiceProcess() {
		return invoiceProcess;
	}

	public void setInvoiceProcess(List<ProcessInfo> invoiceProcess) {
		this.invoiceProcess = invoiceProcess;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InvoiceRecordInfo invoiceRecordInfo = (InvoiceRecordInfo) o;
		return Objects.equals(this.invoiceRecord, invoiceRecordInfo.invoiceRecord)
				&& Objects.equals(this.invoiceItem, invoiceRecordInfo.invoiceItem)
				&& Objects.equals(this.invoiceAssy, invoiceRecordInfo.invoiceAssy)
				&& Objects.equals(this.invoiceProcess, invoiceRecordInfo.invoiceProcess);
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoiceRecord, invoiceItem, invoiceAssy, invoiceProcess);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InvoiceRecordInfo {\n");

		sb.append(" invoiceRecord: ").append(invoiceRecord).append("\n");
		sb.append(" invoiceItem: ").append(invoiceItem).append("\n");
		sb.append(" invoiceAssy: ").append(invoiceAssy).append("\n");
		sb.append(" invoiceProcess: ").append(invoiceProcess).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
