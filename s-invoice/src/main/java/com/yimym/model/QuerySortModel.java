package com.yimym.model;

import java.util.List;
import java.util.Objects;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 表示查询排序
 **/

/**
 * 表示查询排序
 */
@ApiModel(description = "表示查询排序")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class QuerySortModel {
	private List<?> querys = null;
	private SortModel sort = null;

	/**
	 * 查询条件
	 * 
	 * @return querys
	 **/
	@ApiModelProperty(value = "查询条件")
	public List<?> getQuerys() {
		return querys;
	}

	public void setQuerys(List<?> querys) {
		this.querys = querys;
	}

	/**
	 * 排序条件
	 * 
	 * @return sort
	 **/
	@ApiModelProperty(value = "排序条件")
	public SortModel getSort() {
		return sort;
	}

	public void setSort(SortModel sort) {
		this.sort = sort;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		QuerySortModel querySortModel = (QuerySortModel) o;
		return Objects.equals(this.querys, querySortModel.querys) && Objects.equals(this.sort, querySortModel.sort);
	}

	@Override
	public int hashCode() {
		return Objects.hash(querys, sort);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class QuerySortModel {\n");

		sb.append(" querys: ").append(querys).append("\n");
		sb.append(" sort: ").append(sort).append("\n");
		sb.append("}");
		return sb.toString();
	}
}
