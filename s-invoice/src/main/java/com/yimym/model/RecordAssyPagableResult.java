package com.yimym.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yimym.dto.InvRecordAssyDto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 具有分页的发票附件列表
 **/

/**
 * 具有分页的发票附件列表
 */
@ApiModel(description = "具有分页的发票附件列表")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class RecordAssyPagableResult {
	private Long totalPages = null;

	private Long totalElements = null;

	private List<InvRecordAssyDto> recordAssyList = new ArrayList<InvRecordAssyDto>();

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
	 * 发票附件列表
	 * 
	 * @return invoiceList
	 **/
	@ApiModelProperty(value = "发票附件列表")
	@JsonProperty("recordAssyList")
	public List<InvRecordAssyDto> getRecordAssyList() {
		return recordAssyList;
	}

	public void setRecordAssyList(List<InvRecordAssyDto> recordAssyList) {
		this.recordAssyList = recordAssyList;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		RecordAssyPagableResult recordAssyPagableResult = (RecordAssyPagableResult) o;
		return Objects.equals(this.totalPages, recordAssyPagableResult.totalPages)
				&& Objects.equals(this.totalElements, recordAssyPagableResult.totalElements)
				&& Objects.equals(this.recordAssyList, recordAssyPagableResult.recordAssyList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(totalPages, totalElements, recordAssyList);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class RecordAssyPagableResult {\n");

		sb.append(" totalPages: ").append(totalPages).append("\n");
		sb.append(" totalElements: ").append(totalElements).append("\n");
		sb.append(" recordAssyList: ").append(recordAssyList).append("\n");
		sb.append("}\n");
		return sb.toString();
	}

}
