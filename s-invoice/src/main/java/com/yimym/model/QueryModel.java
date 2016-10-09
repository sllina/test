package com.yimym.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "表示自定义查询")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringBootServerCodegen", date = "2016-06-30T10:41:37.660Z")
public class QueryModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7636809853015773020L;
	private String column = null;
	private String value = null;
	private String query = null;
	private String join = null;

	/**
	 * 列名
	 **/
	@ApiModelProperty(value = "列名")
	@JsonProperty("column")
	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	/**
	 * 列名对应的值
	 **/
	@ApiModelProperty(value = "列名对应的值")
	@JsonProperty("value")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 查询方式
	 **/
	@ApiModelProperty(value = "查询方式")
	@JsonProperty("query")
	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * 联结方式
	 **/
	@ApiModelProperty(value = "联结方式")
	@JsonProperty("join")
	public String getJoin() {
		return join;
	}

	public void setJoin(String join) {
		this.join = join;
	}

}
