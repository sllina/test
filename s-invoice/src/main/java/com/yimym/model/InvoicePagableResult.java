package com.yimym.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yimym.dto.InvoiceDto;
import com.yimym.model.Invoice;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * 具有分页的发票列表
 **/

/**
 * 具有分页的发票列表
 */
@ApiModel(description = "具有分页的发票列表")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class InvoicePagableResult {
	private Long totalPages = null;

	private Long totalElements = null;

	private List<InvoiceDto> invoiceList = new ArrayList<InvoiceDto>();

	/**
	 * 总共页数
	 * 
	 * @return totalPages
	 **/
	@ApiModelProperty(value = "总共页数")
	@JsonProperty("totalPages")
	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * 总共资源项数
	 * 
	 * @return totalElements
	 **/
	@ApiModelProperty(value = "总共资源项数")
	@JsonProperty("totalElements")
	public Long getTotalElements() {
		return totalElements;
	}

	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}

	/**
	 * 发票列表
	 * 
	 * @return invoiceList
	 **/
	@ApiModelProperty(value = "发票列表")
	@JsonProperty("invoiceList")
	public List<InvoiceDto> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<InvoiceDto> invoiceList) {
		this.invoiceList = invoiceList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InvoicePagableResult invoicePagableResult = (InvoicePagableResult) o;
		return Objects.equals(this.totalPages, invoicePagableResult.totalPages)
				&& Objects.equals(this.totalElements, invoicePagableResult.totalElements)
				&& Objects.equals(this.invoiceList, invoicePagableResult.invoiceList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalPages, totalElements, invoiceList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class InvoicePagableResult {\n");

		sb.append(" totalPages: ").append(totalPages).append("\n");
		sb.append(" totalElements: ").append(totalElements).append("\n");
		sb.append(" invoiceList: ").append(invoiceList).append("\n");
		sb.append("}\n");
		return sb.toString();
	}
}
