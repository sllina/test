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

import com.yimym.dto.InvRecordAssyDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.RecordAssy;
import com.yimym.model.RecordAssyPagableResult;
import com.yimym.service.RecordAssyService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "", produces = { APPLICATION_JSON_VALUE })
@Api(value = "/assys", description = "the assys API")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-09-07T08:53:13.275Z")
public class AssysApi {
	@Autowired
	RecordAssyService assyservice;
	
	ErrorInfo er = new ErrorInfo();

	@ApiOperation(value = "批量删除开票附件", notes = "批量删除开票附件", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票附件信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/assys", method = RequestMethod.DELETE)
	public ResponseEntity<?> assysDelete(
			@ApiParam(value = "开票附件数组ids", required = true) @RequestParam(value = "ids", required = true) List<String> ids,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			Error error = assyservice.deleteBatchRecordAssy(ids,modifiedBy);
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

	@ApiOperation(value = "查询开票附件信息", notes = "根据条件查询开票附件信息", response = RecordAssyPagableResult.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "开票附件列表", response = RecordAssyPagableResult.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/assys", method = RequestMethod.GET)
	public ResponseEntity<?> assysGet(
			@ApiParam(value = "当前页码，默认1") @RequestParam(value = "page", required = false) Integer page,
			@ApiParam(value = "每页项数，默认99") @RequestParam(value = "pageSize", required = false) Integer pageSize,
			@ApiParam(value = "附件名称") @RequestParam(value = "assyName", required = false) String assyName,
			@ApiParam(value = "排序名称，默认创建时间") @RequestParam(value = "sortName", required = false) String sortName,
			@ApiParam(value = "排序方式，desc或者asc，默认desc") @RequestParam(value = "sort", required = false) String sort) {
		try {
			RecordAssyPagableResult assy = assyservice.getPagableByPram(page, pageSize, assyName, sortName, sort);
			if(assy!=null){
				return new ResponseEntity<RecordAssyPagableResult>(assy,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(HttpStatus.NO_CONTENT);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id删除开票附件信息", notes = "根据id删除开票附件信息", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除开票附件信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/assys/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> assysIdDelete(
			@ApiParam(value = "开票附件id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			int del = assyservice.deleteRecordAssy(id, modifiedBy);
			if(del>0){
				return new ResponseEntity<Error>(er.findOK(),HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordAssy(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据id查询开票附件信息", notes = "根据id查询开票附件信息", response = RecordAssy.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票附件信息", response = RecordAssy.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/assys/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> assysIdGet(
			@ApiParam(value = "开票附件id", required = true) @PathVariable("id") String id) {
		try {
			RecordAssy assy = assyservice.getRecordAssyById(id);
			if(assy!=null){
				return new ResponseEntity<RecordAssy>(assy,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordAssy(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "修改开票附件", notes = "根据请求中指定要更新的属性对开票附件进行更新，必填项为：修改者，不填项：创建者、创建时间、修改时间、开票记录的id，其它字段可选填。 ", response = RecordAssy.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "修改成功", response = RecordAssy.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/assys/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> assysIdPut(
			@ApiParam(value = "开票附件id", required = true) @PathVariable("id") String id,
			@ApiParam(value = "待更新的开票附件信息", required = true) @RequestBody RecordAssy body) {
		try {
			if(body.getModifiedBy()==null){
				return new ResponseEntity<Error>(er.getFailRequire("修改者"),HttpStatus.BAD_REQUEST);
			}
			RecordAssy assy = assyservice.updateRecordAssy(id, body);
			if(assy!=null){
				return new ResponseEntity<RecordAssy>(assy,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordAssy(id),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票记录id，删除开票附件信息", notes = "根据开票记录id，删除开票附件信息", response = Error.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功删除附件信息", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/recordassys/{recordid}", method = RequestMethod.DELETE)
	public ResponseEntity<?> recordassysRecordidDelete(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("recordid") String recordid,
			@ApiParam(value = "修改者", required = true) @RequestParam(value = "modifiedBy", required = true) String modifiedBy) {
		try {
			int del = assyservice.deleteAssyByRecordid(recordid,modifiedBy);
			if(del>0){
				return new ResponseEntity<Error>(er.findOK(),HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordAssyByRecordID(recordid),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票记录id，查询开票附件信息", notes = "根据开票记录id，查询开票附件信息", response = RecordAssy.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功查询开票附件信息", response = RecordAssy.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/recordassys/{recordid}", method = RequestMethod.GET)
	public ResponseEntity<?> recordassysRecordidGet(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("recordid") String recordid) {
		try {
			List<InvRecordAssyDto> assy = assyservice.getRecordAssyByRecordid(recordid);
			if(assy!=null){
				return new ResponseEntity<List<InvRecordAssyDto>>(assy,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.notFoundRecordAssyByRecordID(recordid),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

	@ApiOperation(value = "根据开票记录id，新增开票附件信息", notes = "根据开票记录id，新增开票附件信息，必填项：创建者，不填写项：修改者、修改时间、创建时间，其它选填", response = RecordAssy.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "成功新增开票附件信息", response = RecordAssy.class),
			@ApiResponse(code = 300, message = "必填字段，如果没有填则返回", response = Error.class),
			@ApiResponse(code = 400, message = "无效请求", response = Error.class),
			@ApiResponse(code = 401, message = "未认证", response = Error.class),
			@ApiResponse(code = 403, message = "无访问权限", response = Error.class),
			@ApiResponse(code = 404, message = "没找到指定对象", response = Error.class),
			@ApiResponse(code = 500, message = "未知的错误", response = Error.class) })
	@RequestMapping(value = "/recordassys/{recordid}", method = RequestMethod.POST)
	public ResponseEntity<?> recordassysRecordidPost(
			@ApiParam(value = "开票记录id", required = true) @PathVariable("recordid") String recordid,
			@ApiParam(value = "待新增的开票附件信息", required = true) @RequestBody RecordAssy body) {
		try {
			if(body.getCreatedBy()==null){
				return new ResponseEntity<Error>(er.getFailRequire("创建者"),HttpStatus.BAD_REQUEST);
			}
			
			RecordAssy assy = assyservice.createRecordAssy(recordid, body);
			if(assy!=null){
				return new ResponseEntity<RecordAssy>(assy,HttpStatus.OK);
			}else{
				return new ResponseEntity<Error>(er.regFali(),HttpStatus.BAD_REQUEST);
			}
		}catch (Exception e) {
			return new ResponseEntity<Error>(er.getNotKnownError(e.getMessage()), HttpStatus.BAD_REQUEST);
		}
	}

}
