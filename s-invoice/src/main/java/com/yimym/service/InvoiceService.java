package com.yimym.service;

import java.util.List;

import com.yimym.dto.InvoiceDto;
import com.yimym.model.Error;
import com.yimym.model.Invoice;
import com.yimym.model.InvoiceInfo;
import com.yimym.model.InvoicePagableResult;
import com.yimym.model.QuerySortModel;

public interface InvoiceService {
	//新增发票
	Invoice createInvoice(String orderid,Invoice invoice);
	
	//删除发票
	int deleteInvoice(String id,String modifiedBy);
	
	//批量删除
	Error deleteBatchInvoice(List<String> ids,String modifiedBy);
	
	//修改发票
	Invoice updateInvoice(String id,Invoice invoice);
	
	//根据id查询发票,不完整信息
	Invoice getInvoiceById(String id);
	
	//分页查询
	InvoicePagableResult getPagableByPram(Integer page,Integer pageSize,String orderMakerName,String invoiceStatus);
	
	//根据id查询发票，完整信息
	InvoiceInfo getInvoiceInfoById(String id);

	//根据orderid查询信息
	InvoiceDto getInvoiceByOrderid(String orderid);
	
	//InvoiceInfo getInvoiceInfoByorderid(String orderid);
	
	//修改发票状态
	int updateInvoiceStatus(String id,String invoicestatus,String modifiedBy);
	
	Error updateBatchInvoiceStatus(List<Invoice> ids);
	
	//自定义查询
	InvoicePagableResult findInvoiceBySearch(Integer page,Integer pageSize,QuerySortModel definedsearch);
	
	//自定义，判断输入值是否正确
	Error findByQuerySort(QuerySortModel querys);
	
}
