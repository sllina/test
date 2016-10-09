package com.yimym.model;

import org.springframework.stereotype.Component;

@Component
public class ErrorInfo {
	private String message;
	private String code;
	private Error error = new Error();

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public Error getError() {
		return error;
	}
	
	public Error setError(String code, String message) {
		error.setCode(code);
		error.setMessage(message);
		return error;
	}

	public Error findOK() {
		error.setCode("200");
		error.setMessage("");
		return error;
	}

	public Error getMissParam() {
		error.setCode("400");
		error.setMessage("参数不足");
		return error;
	}

	public Error getBadRequest() {
		error.setCode("400");
		error.setMessage("请求出现错误");
		return error;
	}

	public Error getTypeMismatch() {
		error.setCode("408");
		error.setMessage("处理参数类型转换失败");
		return error;
	}

	public Error getNotKnownError(String message) {
		error.setCode("500");
		error.setMessage(message);
		return error;
	}

	public Error getNotKnownError() {
		error.setCode("500");
		error.setMessage("出现未知错误");
		return error;
	}

	public Error getRequestMethodNotSupported() {
		error.setCode("501");
		error.setMessage("请求方式不支持");
		return error;
	}

	public Error getNoContent() {
		error.setCode("204");
		error.setMessage("未找到相关结果！");
		return error;
	}

	public Error getFailRequire(String name) {
		error.setCode("300");
		error.setMessage("" + name + " 字段不能为空！");
		return error;
	}

	public Error regFali() {
		error.setCode("400");
		error.setMessage("新增失败！");
		return error;
	}

	public Error notFoundID(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票未找到,或者已删除！");
		return error;
	}
	
	public Error notFoundOrderID(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的订单未找到相关发票信息！");
		return error;
	}
	
	public Error notFoundByOrderID(String id) {
		error.setCode("302");
		error.setMessage("订单ID为 " + id + " 的发票已经存在！");
		return error;
	}

	public Error notFoundRecordItem(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票明细未找到,或者已删除！");
		return error;
	}
	
	public Error notFoundRecordAssy(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票附件未找到,或者已删除！");
		return error;
	}
	
	public Error notFoundInvoiceRecord(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票记录未找到,或者已删除！");
		return error;
	}
	
	public Error notFoundInvoiceRecordByInvoiceid(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票未找到相关发票记录！");
		return error;
	}

	public Error notFoundRecordItemByRecordID(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票记录找到相关发票明细！");
		return error;
	}

	public Error notFoundProc(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票记录未找到相关流程信息！");
		return error;
	}

	public Error notFoundRecordAssyByRecordID(String id) {
		error.setCode("204");
		error.setMessage("ID为 " + id + " 的发票记录未找到相关附件！");
		return error;
	}

	/*public Error notFoundByOrderCode(String id) {
		error.setCode("302");
		error.setMessage("订单编号为 " + id + " 的订单已经存在！");
		return error;
	}*/
	
	public Error notFoundParam(String colum,String param){
		error.setCode("300");
		error.setMessage(""+colum+"为"+param+" 的值不在我们的定义取值范围内，请重新输入！");
		return error;
	}

}
