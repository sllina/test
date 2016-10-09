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

import com.yimym.dto.InvoiceRecordDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.InvoiceRecord;
import com.yimym.model.InvoiceRecordInfo;
import com.yimym.model.InvoiceRecordPagableResult;
import com.yimym.model.QuerySortModel;
import com.yimym.model.RecordProcess;
import com.yimym.service.InvoiceRecordService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/records", description = "the records API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")
public class RecordsApi {

	@Autowired
	InvoiceRecordService recordservice;
	
	ErrorInfo er = new ErrorInfo();
	
	@ApiOperation(value = "批量删除开票记录", notes = "批量删除开票记录", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票记录信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/records", method = RequestMethod.DELETE)
	public ResponseEntity<?> recordsDelete(
			@ApiParam(value = "开票记录数组ids", required = true) @RequestParam(value = "ids", required = true) List<String> ids,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			Error error = recordservice.deleteBatchInvoiceRecord(ids,modifiedBy);
			switch(error.getCode()){
				case "200":
					return new ResponseEntity<Error>(error, HttpStatus.OK);
				case "204":
					return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
				case "300":
					return new ResponseEntity<Error>(error,HttpStatus.BAD_REQUEST);
				default :
					return new ResponseEntity<Error>(er.getNotKnownError(),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "查询开票记录信息", notes = "根据条件查询开票记录信息", response = InvoiceRecordPagableResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "开票记录列表", response = InvoiceRecordPagableResult.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/records", method = RequestMethod.GET)
	public ResponseEntity<?> recordsGet(
			@ApiParam(value = "当前页码，默认1") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "每页项数，默认99") @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "客户名称") @RequestParam(value = "clientFullName", required = false) String clientFullName,
			@ApiParam(value = "开票记录的状态") @RequestParam(value = "recordStatus", required = false) String recordStatus) {
		try {
			InvoiceRecordPagableResult record = recordservice.getPagableByPram(page, pageSize, clientFullName, recordStatus);
			if(record!=null){
				return new ResponseEntity<InvoiceRecordPagableResult>(record,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id删除开票记录信息", notes = "根据id删除开票记录信息", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票记录信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/records/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> recordsIdDelete(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			int del = recordservice.deleteInvoiceRecord(id, modifiedBy);
			if(del>0){
				return new ResponseEntity<Error>(er.findOK(),HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundInvoiceRecord(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id查询开票记录信息", notes = "根据id查询开票记录信息", response = InvoiceRecord.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票记录信息", response = InvoiceRecord.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/records/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> recordsIdGet(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "是否查看完整信息，0为完整信息，1为不完整信息,默认查询不完整信息", required = false) @RequestParam(value = "complete", required = false) Integer complete) {
		try {
			if(complete==null || complete.intValue()==1){
				InvoiceRecord record = recordservice.getInvoiceRecordById(id);
				if(record!=null){
					return new ResponseEntity<InvoiceRecord>(record,HttpStatus.OK);
				}
			}else{
				InvoiceRecordInfo info = recordservice.getInvoiceRecordInfoById(id);
				if(info!=null){
					return new ResponseEntity<InvoiceRecordInfo>(info,HttpStatus.OK);
				}
			}
			return new ResponseEntity<Error>(er.notFoundInvoiceRecord(id),HttpStatus.BAD_REQUEST);
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票记录id，查询流程信息", notes = "根据开票记录id，查询流程信息", response = RecordProcess.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票记录的流程信息", response = RecordProcess.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/records/{id}/procs", method = RequestMethod.GET)
	public ResponseEntity<?> recordsIdProcsGet(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("id") String id) {
		try {
			RecordProcess pro = recordservice.getRecordProcessById(id);
			if(pro!=null){
				return new ResponseEntity<RecordProcess>(pro,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundProc(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "修改开票记录", notes = "根据请求中指定要更新的属性对开票记录进行更新，必填项为：修改者，不填写项：开票id、修改时间、创建时间、创建者、开票记录的状态，其它字段选填。 ", response = InvoiceRecord.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = InvoiceRecord.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/records/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> recordsIdPut(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "待更新的开票记录信息", required = true) @RequestBody InvoiceRecord body) {
		try {
			if(body.getModifiedBy()==null){
				return new ResponseEntity<Error>(er.getFailRequire("修改者"),HttpStatus.BAD_REQUEST);
			}
			InvoiceRecord record = recordservice.updateInvoiceRecord(id, body);
			if(record!=null){
				return new ResponseEntity<InvoiceRecord>(record,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundInvoiceRecord(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "自定义查询", notes = "自定义查询条件，自定义查询格式：<br/>"
			+ "\"column\"：表示列名,选择内容如下：{id, invoiceid, createdAt, createdBy,createdByName,recordCode, orderCode, dutyNumber,<br/>"
			+ "clientFullName, clientAddress, phone, clientBankFullName, clientBankAccount, subInvoicePrice,<br/>"
			+ "invoiceType, taxRate, recordStatus, modifiedAt, modifiedBy,modifiedByName}<br/>"
			+ "\"join\"：表示联结方式，包括\"and\"、\"or\"两种；<br/>"
			+ "\"query\"：表示查询方式，选择如下：{like、in、not in、>、>=、<、<=、=、!=}；<br/>"
			+ "\"value\"：表示要查询的值,如果是时间可输入的格式为:yyyy-MM-dd或者yyyy-MM-dd HH:mm:ss。<br/>"
			+ "\"name\":表示排序的名称，选择如下：{id, invoiceid, createdAt, createdBy,createdByName,recordCode, orderCode, dutyNumber,<br/>"
			+ "clientFullName, clientAddress, phone, clientBankFullName, clientBankAccount, subInvoicePrice,<br/>"
			+ "invoiceType, taxRate, recordStatus, modifiedAt, modifiedBy,modifiedByName}<br/>"
			+ "\"sort\":表示排序：包括“desc”、“asc”两种<br/>"
			+ "例：查询订单状态为1的订单，同时根据订单名称或者订单项名称进行查询，按照创建时间降序排列<br/>"
			+ "{\"querys\":<br/>[{\"column\":\"recordStatus\",\"join\":\"and\",\"query\":\"=\",\"value\":\"1\"},<br/>{\"column\":\"createdAt\",\"join\":\"and\",\"query\":\">\",\"value\":\"2016-08-09\"},<br/>"
			+ "[{\"column\":\"createdByName\",\"join\":\"and\",\"query\":\"like\",\"value\":\"test\"},<br/>{\"column\":\"modifiedByName\",\"join\":\"or\",\"query\":\"like\",\"value\":\"test\"}<br/>]],<br/>"
			+ "\"sort\":{\"name\":\"createdAt\",\"sort\":\"desc\"}<br/>"
			+ " }<br/>", response = InvoiceRecordPagableResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "开票信息列表", response = InvoiceRecordPagableResult.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/records", method = RequestMethod.PUT)
	public ResponseEntity<?> recordsPut(
			@ApiParam(value = "当前页码，默认1") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "每页项数，默认99") @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "自定义查询条件",required=true) @RequestBody QuerySortModel querySortModel) {
		try {
			Error error = recordservice.findByQuerySort(querySortModel);
			
			if(error!=null){
				return new ResponseEntity<Error>(error,HttpStatus.BAD_GATEWAY);
			}
			
			InvoiceRecordPagableResult info = recordservice.findInvoiceRecordBySearch(page,pageSize,querySortModel);
			if(info!=null){
				return new ResponseEntity<InvoiceRecordPagableResult>(info,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票id，查询开票记录信息", notes = "根据开票id，查询开票记录信息", response = InvoiceRecord.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票记录信息", response = InvoiceRecord.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoicerecords/{invoiceid}", method = RequestMethod.GET)
	public ResponseEntity<?> invoicerecordsInvoiceidGet(
			@ApiParam(value = "开票id", required = true) @PathVariable("invoiceid") String invoiceid) {
		try {
			List<InvoiceRecordDto> record = recordservice.getInvoiceRecordByInvoiceid(invoiceid);
			if(record!=null){
				return new ResponseEntity<List<InvoiceRecordDto>>(record,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundInvoiceRecordByInvoiceid(invoiceid),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票id，新增开票记录信息", notes = "根据开票id新增开票记录信息，必填项：创建者，不填写项：修改者、修改时间、创建时间、开票记录的状态，其它选填", response = InvoiceRecord.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功新增开票记录信息", response = InvoiceRecord.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/invoicerecords/{invoiceid}", method = RequestMethod.POST)
	public ResponseEntity<?> invoicerecordsInvoiceidPost(
			@ApiParam(value = "开票id", required = true) @PathVariable("invoiceid") String invoiceid,
			@ApiParam(value = "待新增的开票记录信息", required = true) @RequestBody InvoiceRecord body
	) {
		try {
			if(body.getCreatedBy()==null){
				return new ResponseEntity<Error>(er.getFailRequire("创建者"),HttpStatus.BAD_REQUEST);
			}
			InvoiceRecord record = recordservice.createInvoiceRecord(invoiceid, body);
			if(record!=null){
				return new ResponseEntity<InvoiceRecord>(record,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.regFali(),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
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
	@ApiOperation(value = "根据id修改开票记录状态", notes = "根据请求参数对开票记录状态进行更新 ", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = Error.class),
			@ApiResponse(code = 204, message = "未找到结果", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 404, message = "请求出现错误", response = Error.class),
			@ApiResponse(code = 500, message = "出现了未知的错误", response = Error.class) })
	@RequestMapping(value = "/records/{id}/status", method = RequestMethod.PUT)
	public ResponseEntity<?> recordByIdPut(@ApiParam(value = "id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "invoiceStatus", required = true) @RequestParam(value = "invoiceStatus", required = true) String invoiceStatus,
			@ApiParam(value = "modifiedBy", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			int update = recordservice.updateRecordStatus(id, invoiceStatus, modifiedBy);
			if (update > 0) {
				return new ResponseEntity<Error>(er.findOK(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Error>(er.notFoundInvoiceRecord(id), HttpStatus.BAD_REQUEST);
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
	@ApiOperation(value = "批量修改开票记录状态", notes = "只需填写id、开票记录状态、修改人，不填则返回300，其它不需要填写;", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = Error.class),
			@ApiResponse(code = 204, message = "未找到结果", response = Error.class),
			@ApiResponse(code = 300, message = "必输字段为空", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 404, message = "请求出现错误", response = Error.class),
			@ApiResponse(code = 500, message = "出现了未知的错误", response = Error.class) })
	@RequestMapping(value = "/records/status", method = RequestMethod.PUT)
	public ResponseEntity<?> recordByBodyPut(
			@ApiParam(value = "修改开票记录状态", required = true) @RequestBody List<InvoiceRecord> ids) {
		try {
			Error error = recordservice.updateBatchRecordStatus(ids);
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

}
