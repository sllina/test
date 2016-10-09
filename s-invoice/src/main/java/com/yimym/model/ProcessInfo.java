package com.yimym.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

/**
 * ProcessInfo
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")

public class ProcessInfo {
	private Process process = null;

	private List<Task> task = new ArrayList<Task>();

	/**
	 * 流程信息
	 * 
	 * @return process
	 **/
	@ApiModelProperty(value = "流程信息")
	@JsonProperty("process")
	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	/**
	 * 任务信息
	 * 
	 * @return task
	 **/
	@ApiModelProperty(value = "任务信息")
	@JsonProperty("task")
	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProcessInfo processInfo = (ProcessInfo) o;
		return Objects.equals(this.process, processInfo.process) && Objects.equals(this.task, processInfo.task);
	}

	@Override
	public int hashCode() {
		return Objects.hash(process, task);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProcessInfo {\n");

		sb.append("    process: ").append(process).append("\n");
		sb.append("    task: ").append(task).append("\n");
		sb.append("}");
		return sb.toString();
	}

}
