package com.yimym.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yimym.dto.InvoiceDto;
import com.yimym.dto.InvoiceRecordDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票的所有信息
 **/

/**
 * 发票的所有信息
 */
@ApiModel(description = "发票的所有信息")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class InvoiceInfo {
	private InvoiceDto invoice = null;

	private List<InvoiceRecordDto> invoiceRecord = new ArrayList<InvoiceRecordDto>();

	/**
	 * 发票信息
	 * 
	 * @return invoice
	 **/
	@ApiModelProperty(value = "发票信息")
	@JsonProperty("invoice")
	public InvoiceDto getInvoice() {
		return invoice;
	}

	public void setInvoice(InvoiceDto invoice) {
		this.invoice = invoice;
	}

	/**
	 * 发票记录
	 * 
	 * @return invoiceRecord
	 **/
	@ApiModelProperty(value = "发票记录")
	@JsonProperty("invoiceRecord")
	public List<InvoiceRecordDto> getInvoiceRecord() {
		return invoiceRecord;
	}

	public void setInvoiceRecord(List<InvoiceRecordDto> invoiceRecord) {
		this.invoiceRecord = invoiceRecord;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InvoiceInfo invoiceInfo = (InvoiceInfo) o;
		return Objects.equals(this.invoice, invoiceInfo.invoice)
				&& Objects.equals(this.invoiceRecord, invoiceInfo.invoiceRecord);
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoice, invoiceRecord);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InvoiceInfo {\n");
		sb.append(" invoice: ").append(invoice).append("\n");
		sb.append(" invoiceRecord: ").append(invoiceRecord).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
