package com.yimym.service;

import java.util.List;

import com.yimym.dto.InvoiceRecordDto;
import com.yimym.model.Error;
import com.yimym.model.InvoiceRecord;
import com.yimym.model.InvoiceRecordInfo;
import com.yimym.model.InvoiceRecordPagableResult;
import com.yimym.model.QuerySortModel;
import com.yimym.model.RecordProcess;

public interface InvoiceRecordService {
	//新增发票记录
	InvoiceRecord createInvoiceRecord(String invoiceid,InvoiceRecord invrecord);
	
	//删除发票记录
	int deleteInvoiceRecord(String id,String modifiedBy);
	
	//批量删除发票记录
	Error deleteBatchInvoiceRecord(List<String> ids,String modifiedBy);
	
	//修改发票记录
	InvoiceRecord updateInvoiceRecord(String id,InvoiceRecord invrecord);
	
	//根据id查询发票记录
	InvoiceRecord getInvoiceRecordById(String id);
	
	//分页查询
	InvoiceRecordPagableResult getPagableByPram(Integer page,Integer pageSize,String clientFullName,String recordStatus);
	
	//根据id查询发票记录  完整信息
	InvoiceRecordInfo getInvoiceRecordInfoById(String id);
	
	//根据id获取流程信息
	RecordProcess getRecordProcessById(String id);
	
	//根据发票id得到发票记录
	List<InvoiceRecordDto> getInvoiceRecordByInvoiceid(String invoiceid);
	
	int updateRecordStatus(String id,String recordStatus,String modifiedBy);
	
	Error updateBatchRecordStatus(List<InvoiceRecord> ids);
	
	//自定义查询
	InvoiceRecordPagableResult findInvoiceRecordBySearch(Integer page,Integer pageSize,QuerySortModel definedsearch);
	
	//自定义，判断输入值是否正确
	Error findByQuerySort(QuerySortModel querys);
	
}
