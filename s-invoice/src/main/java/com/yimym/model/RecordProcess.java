package com.yimym.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yimym.dto.InvoiceRecordDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 发票记录以及流程信息
 **/

/**
 * 发票记录以及流程信息
 */
@ApiModel(description = "发票记录以及流程信息")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class RecordProcess {
	private InvoiceRecordDto invoiceRecord = null;

	private List<ProcessInfo> recordProcess = new ArrayList<ProcessInfo>();

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
	 * 流程信息
	 * 
	 * @return recordProcess
	 **/
	@ApiModelProperty(value = "流程信息")
	public List<ProcessInfo> getRecordProcess() {
		return recordProcess;
	}

	public void setRecordProcess(List<ProcessInfo> recordProcess) {
		this.recordProcess = recordProcess;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RecordProcess recordProcess = (RecordProcess) o;
		return Objects.equals(this.invoiceRecord, recordProcess.invoiceRecord)
				&& Objects.equals(this.recordProcess, recordProcess.recordProcess);
	}

	@Override
	public int hashCode() {
		return Objects.hash(invoiceRecord, recordProcess);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RecordProcess {\n");

		sb.append(" invoiceRecord: ").append(invoiceRecord).append("\n");
		sb.append(" recordProcess: ").append(recordProcess).append("\n");
		sb.append("}\n");
		return sb.toString();
	}

}
