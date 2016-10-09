package com.yimym.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;




/**
 * SortModel
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class SortModel   {
  private String name = null;
  private String sort = null;

   /**
   * 排序列名
   * @return name
  **/
  @ApiModelProperty(value = "排序列名")
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

   /**
   * 排序方式
   * @return sort
  **/
  @ApiModelProperty(value = "排序方式")
  @JsonProperty("sort")
  public String getSort() {
    return sort;
  }

  public void setSort(String sort) {
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
    SortModel sortModel = (SortModel) o;
    return Objects.equals(this.name, sortModel.name) &&
        Objects.equals(this.sort, sortModel.sort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, sort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SortModel {\n");
    
    sb.append(" name: ").append(name).append("\n");
    sb.append(" sort: ").append(sort).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

