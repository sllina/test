package com.yimym.service;

import java.util.List;

import com.yimym.dto.InvRecordItemDto;
import com.yimym.model.Error;
import com.yimym.model.RecordItem;
import com.yimym.model.RecordItemPagableResult;

public interface RecordItemService {
	//新增发票明细
	RecordItem createRecordItem(String recordid,RecordItem recorditem);
		
	//删除发票明细
	int deleteRecordItem(String id,String modifiedBy);
	
	//批量删除发票明细
	Error deleteBatchRecordItem(List<String> ids,String modifiedBy);
	
	//修改发票明细
	RecordItem updateRecordItem(String id,RecordItem recorditem);
	
	//根据id查询发票明细
	RecordItem getRecordItemById(String id);
	
	//分页查询
	RecordItemPagableResult getPagableByPram(Integer page,Integer pageSize,String itemName);
	
	//根据发票记录id查询
	List<InvRecordItemDto> getRecordItemByRecordid(String recordid);
	
}
