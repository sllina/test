package com.yimym.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yimym.dto.InvRecordItemDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 具有分页的发票明细列表
 **/

/**
 * 具有分页的发票明细列表
 */
@ApiModel(description = "具有分页的发票明细列表")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class RecordItemPagableResult {
	private Long totalPages = null;

	private Long totalElements = null;

	private List<InvRecordItemDto> recordItemList = new ArrayList<InvRecordItemDto>();

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
	 * 发票明细列表
	 * 
	 * @return invoiceList
	 **/
	@ApiModelProperty(value = "发票明细列表")
	@JsonProperty("recordItemList")
	public List<InvRecordItemDto> getRecordItemList() {
		return recordItemList;
	}

	public void setRecordItemList(List<InvRecordItemDto> recordItemList) {
		this.recordItemList = recordItemList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RecordItemPagableResult recordItemPagableResult = (RecordItemPagableResult) o;
		return Objects.equals(this.totalPages, recordItemPagableResult.totalPages)
				&& Objects.equals(this.totalElements, recordItemPagableResult.totalElements)
				&& Objects.equals(this.recordItemList, recordItemPagableResult.recordItemList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalPages, totalElements, recordItemList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RecordItemPagableResult {\n");

		sb.append(" totalPages: ").append(totalPages).append("\n");
		sb.append(" totalElements: ").append(totalElements).append("\n");
		sb.append(" recordItemList: ").append(recordItemList).append("\n");
		sb.append("}\n");
		return sb.toString();
	}

}
