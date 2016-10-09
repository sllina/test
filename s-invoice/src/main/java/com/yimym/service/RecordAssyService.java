package com.yimym.service;

import java.util.List;

import com.yimym.dto.InvRecordAssyDto;
import com.yimym.model.Error;
import com.yimym.model.RecordAssy;
import com.yimym.model.RecordAssyPagableResult;

public interface RecordAssyService {
	//新增发票明细
	RecordAssy createRecordAssy(String recordid,RecordAssy recordassy);
			
	//删除发票明细
	int deleteRecordAssy(String id,String modifiedBy);
	
	//批量删除发票明细
	Error deleteBatchRecordAssy(List<String> ids,String modifiedBy);
	
	//修改发票明细
	RecordAssy updateRecordAssy(String id,RecordAssy recordassy);
	
	//根据id查询发票明细
	RecordAssy getRecordAssyById(String id);
	
	//分页查询
	RecordAssyPagableResult getPagableByPram(Integer page,Integer pageSize,String assyName,String sortName,String sort);
	
	//根据发票记录id查询
	List<InvRecordAssyDto> getRecordAssyByRecordid(String recordid);
	
	//根据发票记录id删除发票明细
	int deleteAssyByRecordid(String recordid,String modifiedBy);
}
