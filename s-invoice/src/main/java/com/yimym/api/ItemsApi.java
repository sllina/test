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

import com.yimym.dto.InvRecordItemDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.RecordItem;
import com.yimym.model.RecordItemPagableResult;
import com.yimym.service.RecordItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/items", description = "the items API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")
public class ItemsApi {
	@Autowired
	RecordItemService itemservice;

	ErrorInfo er = new ErrorInfo();
	
	@ApiOperation(value = "批量删除开票明细", notes = "批量删除开票明细", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票明细信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/items", method = RequestMethod.DELETE)
	public ResponseEntity<?> itemsDelete(
			@ApiParam(value = "开票明细数组ids", required = true) @RequestParam(value = "ids", required = true) List<String> ids,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			Error error = itemservice.deleteBatchRecordItem(ids,modifiedBy);
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

	@ApiOperation(value = "查询开票明细信息", notes = "根据条件查询开票明细信息", response = RecordItemPagableResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "开票明细列表", response = RecordItemPagableResult.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public ResponseEntity<?> itemsGet(
			@ApiParam(value = "当前页码，默认1") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "每页项数，默认99") @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "产品名称") @RequestParam(value = "itemName", required = false) String itemName) {
		try {
			RecordItemPagableResult item= itemservice.getPagableByPram(page, pageSize, itemName);
			if(item!=null){
				return new ResponseEntity<RecordItemPagableResult>(item,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id删除开票明细信息", notes = "根据id删除开票明细信息", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票明细信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/items/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> itemsIdDelete(
			@ApiParam(value = "开票明细id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			int del = itemservice.deleteRecordItem(id, modifiedBy);
			if(del>0){
				return new ResponseEntity<Error>(er.findOK(),HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordItem(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id查询开票明细信息", notes = "根据id查询开票明细信息", response = RecordItem.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票明细信息", response = RecordItem.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/items/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> itemsIdGet(
			@ApiParam(value = "开票明细id", required = true) @PathVariable("id") String id) {
		try {
			RecordItem item = itemservice.getRecordItemById(id);
			if(item!=null){
				return new ResponseEntity<RecordItem>(item,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordItem(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "修改开票明细", notes = "根据请求中指定要更新的属性对开票明细进行更新，必填项为：修改者，不填项：创建者、创建时间、修改时间、开票记录的id，其它字段可选填。 ", response = RecordItem.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = RecordItem.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/items/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> itemsIdPut(
			@ApiParam(value = "开票明细id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "待更新的开票明细信息", required = true) @RequestBody RecordItem body) {
		try {
			if(body.getModifiedBy()==null){
				return new ResponseEntity<Error>(er.getFailRequire("修改者"),HttpStatus.BAD_REQUEST);
			}
			RecordItem item = itemservice.updateRecordItem(id, body);
			if(item!=null){
				return new ResponseEntity<RecordItem>(item,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordItem(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票记录id，查询开票明细信息", notes = "根据开票记录id，查询开票明细信息", response = RecordItem.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票明细信息", response = RecordItem.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/recorditems/{recordid}", method = RequestMethod.GET)
	public ResponseEntity<?> recorditemsRecordidGet(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("recordid") String recordid) {
		try {
			List<InvRecordItemDto> li = itemservice.getRecordItemByRecordid(recordid);
			if(li!=null){
				return new ResponseEntity<List<InvRecordItemDto>>(li,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordItemByRecordID(recordid),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票记录id，新增开票明细信息", notes = "根据开票记录id新增开票明细信息，必填项：创建者，不填写项：修改者、修改时间、创建时间，其它选填", response = RecordItem.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功新增开票明细信息", response = RecordItem.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/recorditems/{recordid}", method = RequestMethod.POST)
	public ResponseEntity<?> recorditemsRecordidPost(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("recordid") String recordid,
			@ApiParam(value = "待新增的开票明细信息", required = true) @RequestBody RecordItem body) {
		try {
			if(body.getCreatedBy()==null){
				return new ResponseEntity<Error>(er.getFailRequire("创建者"),HttpStatus.BAD_REQUEST);
			}
			
			RecordItem item = itemservice.createRecordItem(recordid, body);
			if(item!=null){
				return new ResponseEntity<RecordItem>(item,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.regFali(),HttpStatus.BAD_REQUEST);
			}
			
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

}
