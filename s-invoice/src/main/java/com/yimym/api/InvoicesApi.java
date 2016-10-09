package com.yimym.api;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yimym.dto.InvoiceDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.Invoice;
import com.yimym.model.InvoiceInfo;
import com.yimym.model.InvoicePagableResult;
import com.yimym.model.QuerySortModel;
import com.yimym.service.InvoiceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/invoices", description = "the invoices API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")
public class InvoicesApi {
	@Autowired
	InvoiceService invoiceservice;

	ErrorInfo er = new ErrorInfo();

	@ApiOperation(value = "批量删除开票信息", notes = "批量删除开票信息", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices", method = RequestMethod.DELETE)
	public ResponseEntity<?> invoicesDelete(
			@ApiParam(value = "开票数组ids", required = true) @RequestParam(value = "ids", required = true) List<String> ids,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			Error error = invoiceservice.deleteBatchInvoice(ids, modifiedBy);
			switch (error.getCode()) {
			case "200":
				return new ResponseEntity<Error>(error, HttpStatus.OK);
			case "204":
				return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
			case "300":
				return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
			default:
				return new ResponseEntity<Error>(er.getNotKnownError(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "查询开票信息", notes = "根据条件查询开票信息", response = InvoicePagableResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "开票信息列表", response = InvoicePagableResult.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices", method = RequestMethod.GET)
	public ResponseEntity<?> invoicesGet(
			@ApiParam(value = "当前页码，默认1") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "每页项数，默认99") @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "销售人员姓名") @RequestParam(value = "orderMakerName", required = false) String orderMakerName,
			@ApiParam(value = "开票状态") @RequestParam(value = "invoiceStatus", required = false) String invoiceStatus) {
		try {
			InvoicePagableResult invoice = invoiceservice.getPagableByPram(page, pageSize, orderMakerName,invoiceStatus);
			if (invoice != null) {
				return new ResponseEntity<InvoicePagableResult>(invoice, HttpStatus.OK);
			} else {
				return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id删除开票信息", notes = "根据id删除开票信息", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> invoicesIdDelete(@ApiParam(value = "开票id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			int del = invoiceservice.deleteInvoice(id, modifiedBy);
			if (del > 0) {
				return new ResponseEntity<Error>(er.findOK(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Error>(er.notFoundID(id), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id查询开票信息", notes = "根据id查询开票信息", response = Invoice.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票信息", response = Invoice.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> invoicesIdGet(@ApiParam(value = "开票id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "是否查看完整信息，0为完整信息，1为不完整信息,默认查询不完整信息", required = false) @RequestParam(value = "complete", required = false) Integer complete) {
		try {
			if (complete == null || complete.intValue() == 1) {
				Invoice invoice = invoiceservice.getInvoiceById(id);
				if (invoice != null) {
					return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
				}
			} else {
				InvoiceInfo invoiceinfo = invoiceservice.getInvoiceInfoById(id);
				if (invoiceinfo != null) {
					return new ResponseEntity<InvoiceInfo>(invoiceinfo, HttpStatus.OK);
				}
			}
			return new ResponseEntity<Error>(er.notFoundID(id), HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "修改开票", notes = "根据请求中指定要更新的属性对开票信息进行更新，必填项为：修改者，不需要填写的项为：创建时间，修改时间，创建者，订单id，开票状态。 ", response = Invoice.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = Invoice.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> invoicesIdPut(@ApiParam(value = "开票ID", required = true) @PathVariable("id") String id,
			@ApiParam(value = "待更新的开票信息", required = true) @RequestBody Invoice body) {
		try {
			if (body.getModifiedBy() == null) {
				return new ResponseEntity<Error>(er.getFailRequire("修改者"), HttpStatus.BAD_REQUEST);
			}
			Invoice invoice = invoiceservice.updateInvoice(id, body);
			if (invoice != null) {
				return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
			} else {
				return new ResponseEntity<Error>(er.notFoundID(id), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "自定义查询", notes = "自定义查询条件，自定义查询格式：<br/>"
			+ "\"column\"：表示列名,选择内容如下：{id,orderid,createdAt,createdBy,turnOver,invoicePrice,invoiceStatus,orderCode,clientid,clientFullName,orderMakerid,orderMakerName,modifiedAt,<br/>modifiedBy}<br/>"
			+ "\"join\"：表示联结方式，包括\"and\"、\"or\"两种；<br/>"
			+ "\"query\"：表示查询方式，选择如下：{like、in、not in、>、>=、<、<=、=、!=}；<br/>"
			+ "\"value\"：表示要查询的值,如果是时间可输入的格式为:yyyy-MM-dd或者yyyy-MM-dd HH:mm:ss。<br/>"
			+ "\"name\":表示排序的名称，选择如下：{orderid,createdAt,createdBy,turnOver,invoicePrice,invoiceStatus,orderCode,clientid,clientFullName,orderMakerid,orderMakerName,modifiedAt,<br/>modifiedBy}<br/>"
			+ "\"sort\":表示排序：包括“desc”、“asc”两种<br/>"
			+ "例：查询订单状态为1的订单，同时根据订单名称或者订单项名称进行查询，按照创建时间降序排列<br/>"
			+ "{\"querys\":<br/>[{\"column\":\"invoiceStatus\",\"join\":\"and\",\"query\":\"=\",\"value\":\"1\"},<br/>{\"column\":\"createdAt\",\"join\":\"and\",\"query\":\">\",\"value\":\"2016-09-09\"},<br/>"
			+ "[{\"column\":\"orderCode\",\"join\":\"and\",\"query\":\"like\",\"value\":\"test\"},<br/>{\"column\":\"orderMakerName\",\"join\":\"or\",\"query\":\"like\",\"value\":\"test\"}<br/>]],<br/>"
			+ "\"sort\":{\"name\":\"createdAt\",\"sort\":\"desc\"}<br/>"
			+ " }<br/>", response = InvoicePagableResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "开票信息列表", response = InvoicePagableResult.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices", method = RequestMethod.PUT)
	public ResponseEntity<?> invoicesPut(
			@ApiParam(value = "当前页码，默认1") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "每页项数，默认99") @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "自定义查询条件", required = true) @RequestBody QuerySortModel querySortModel) {
		try {
			Error error = invoiceservice.findByQuerySort(querySortModel);
			
			if(error!=null){
				return new ResponseEntity<Error>(error,HttpStatus.BAD_GATEWAY);
			}
			
			InvoicePagableResult info = invoiceservice.findInvoiceBySearch(page,pageSize,querySortModel);
			if(info!=null){
				return new ResponseEntity<InvoicePagableResult>(info,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据订单id查询开票信息", notes = "根据订单id查询开票信息", response = Invoice.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票信息", response = Invoice.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/orderinvoices/{orderid}", method = RequestMethod.GET)
	public ResponseEntity<?> orderinvoicesOrderidGet(
			@ApiParam(value = "订单id", required = true) @PathVariable("orderid") String orderid) {
		try {
			InvoiceDto invoice = invoiceservice.getInvoiceByOrderid(orderid);
			if (invoice != null) {
				return new ResponseEntity<InvoiceDto>(invoice, HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundOrderID(orderid), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据订单id，新增开票信息", notes = "根据订单id新增开票信息,必填项为创建者，不需要填写的项为：创建时间，修改时间，修改者，开票状态", response = Invoice.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功新增开票信息", response = Invoice.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/orderinvoices/{orderid}", method = RequestMethod.POST)
	public ResponseEntity<?> orderinvoicesOrderidPost(
			@ApiParam(value = "订单id", required = true) @PathVariable("orderid") String orderid,
			@ApiParam(value = "待新增的开票信息", required = true) @RequestBody Invoice body) {
		try {
			if (body.getCreatedBy() == null) {
				return new ResponseEntity<Error>(er.getFailRequire("创建者"), HttpStatus.BAD_REQUEST);
			}

			Invoice invoice = invoiceservice.createInvoice(orderid, body);
			if (invoice != null) {
				return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
			} else {
				return new ResponseEntity<Error>(er.regFali(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 根据id，修改订单的状态
	 * 
	 * @param id
	 * @param status
	 * @param modifiedBy
	 * @return
	 */
	@ApiOperation(value = "根据id修改开票状态", notes = "根据请求参数对开票状态进行更新 ", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = Error.class),
			@ApiResponse(code = 204, message = "未找到结果", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 404, message = "请求出现错误", response = Error.class),
			@ApiResponse(code = 500, message = "出现了未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices/{id}/status", method = RequestMethod.PUT)
	public ResponseEntity<?> invoiceByIdPut(@ApiParam(value = "id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "invoiceStatus", required = true) @RequestParam(value = "invoiceStatus", required = true) String invoiceStatus,
			@ApiParam(value = "modifiedBy", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			int update = invoiceservice.updateInvoiceStatus(id, invoiceStatus, modifiedBy);
			if (update > 0) {
				return new ResponseEntity<Error>(er.findOK(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Error>(er.notFoundID(id), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 批量修改订单的状态，根据id
	 * 
	 * @param ids
	 * @return
	 */
	@ApiOperation(value = "批量修改开票状态", notes = "只需填写id、开票状态、修改人，不填则返回300，其它不需要填写;", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = Error.class),
			@ApiResponse(code = 204, message = "未找到结果", response = Error.class),
			@ApiResponse(code = 300, message = "必输字段为空", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 404, message = "请求出现错误", response = Error.class),
			@ApiResponse(code = 500, message = "出现了未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices/status", method = RequestMethod.PUT)
	public ResponseEntity<?> invoiceByBodyPut(
			@ApiParam(value = "修改开票状态", required = true) @RequestBody List<Invoice> ids) {
		try {
			Error error = invoiceservice.updateBatchInvoiceStatus(ids);
			switch (error.getCode()) {
			case "200":
				return new ResponseEntity<Error>(error, HttpStatus.OK);
			case "300":
				return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
			case "204":
				return new ResponseEntity<Error>(error, HttpStatus.BAD_REQUEST);
			default:
				return new ResponseEntity<Error>(er.getNotKnownError(), HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "查询订单id是否存在", notes = "查询订单id是否存在", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "订单id可正常使用", response = Error.class),
			@ApiResponse(code = 302, message = "订单id已存在", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoices/orderid", method = RequestMethod.GET)
	public ResponseEntity<?> orderOrderidGet(
			@ApiParam(value = "订单id", required = true) @RequestParam(value="orderid", required = true) String orderid) {
		try {
			InvoiceDto invoice = invoiceservice.getInvoiceByOrderid(orderid);
			if (invoice != null) {
				return new ResponseEntity<Error>(er.notFoundByOrderID(orderid), HttpStatus.FOUND);
			}else{
				return new ResponseEntity<Error>(er.findOK(), HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

}
