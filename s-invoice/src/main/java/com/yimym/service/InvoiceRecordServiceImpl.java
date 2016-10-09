package com.yimym.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yimym.dto.InvRecordAssyDto;
import com.yimym.dto.InvRecordItemDto;
import com.yimym.dto.InvoiceRecordDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.InvoiceRecord;
import com.yimym.model.InvoiceRecordInfo;
import com.yimym.model.InvoiceRecordPagableResult;
import com.yimym.model.ProcessInfo;
import com.yimym.model.QueryModel;
import com.yimym.model.QuerySortModel;
import com.yimym.model.RecordProcess;
import com.yimym.model.SortModel;
import com.yimym.repository.InvoiceRecordDao;
import com.yimym.repository.InvoiceRecordDaoImpl;
import com.yimym.repository.RecordAssyDao;
import com.yimym.repository.RecordItemDao;
import com.yimym.util.SerialTool;

@Service
public class InvoiceRecordServiceImpl implements InvoiceRecordService {

	@Autowired
	InvoiceRecordDao invoicerecorddao;

	@Autowired
	RecordItemDao recorditemdao;

	@Autowired
	RecordAssyDao recordassydao;
	
	@Autowired
	InvoiceRecordDaoImpl invoicerecorddaoimpl;
	
	@Autowired
	ProcessService processservice;
	
	
	ErrorInfo er = new ErrorInfo();
	
	String[] column = { "id", "invoiceid", "createdAt", "createdBy","createdByName", "recordCode", "orderCode", "dutyNumber",
			"clientFullName", "clientAddress", "phone", "clientBankFullName", "clientBankAccount", "subInvoicePrice",
			"invoiceType", "taxRate", "recordStatus", "modifiedAt", "modifiedBy","modifiedByName" };

	private SerialTool st = new SerialTool();

	// 新增发票记录
	@Override
	@Transactional
	public InvoiceRecord createInvoiceRecord(String invoiceid, InvoiceRecord invrecord) {
		InvoiceRecordDto irdto = new InvoiceRecordDto();
		irdto.setId(new SerialTool().getUUID());
		irdto.setClientAddress(invrecord.getClientAddress());
		irdto.setClientBankAccount(invrecord.getClientBankAccount());
		irdto.setClientBankFullName(invrecord.getClientBankFullName());
		irdto.setClientFullName(invrecord.getClientFullName());
		irdto.setCreatedAt(new Date());
		irdto.setCreatedByName(invrecord.getCreatedByName());
		irdto.setCreatedBy(invrecord.getCreatedBy());
		irdto.setDutyNumber(invrecord.getDutyNumber());
		irdto.setInvoiceid(invoiceid);
		irdto.setInvoiceType(invrecord.getInvoiceType());
		irdto.setOrderCode(invrecord.getOrderCode());
		irdto.setPhone(invrecord.getPhone());
		irdto.setRecordCode(invrecord.getRecordCode());
		irdto.setRecordStatus("0");
		irdto.setRemark(invrecord.getRemark());
		irdto.setStatus("0");
		irdto.setSubInvoicePrice(invrecord.getSubInvoicePrice());
		irdto.setTaxRate(invrecord.getTaxRate());

		InvoiceRecordDto in = invoicerecorddao.save(irdto);
		if (in != null) {
			invrecord.setId(in.getId());
			invrecord.setInvoiceid(in.getInvoiceid());
			invrecord.setCreatedAt(in.getCreatedAt());
			invrecord.setRecordStatus(in.getRecordStatus());
			return invrecord;
		}

		return null;
	}

	// 删除发票记录，根据id
	@Override
	@Transactional
	public int deleteInvoiceRecord(String id, String modifiedBy) {
		return invoicerecorddao.deleteInvoiceRecord(id, modifiedBy, new Date());
	}

	// 批量删除发票记录
	@Override
	@Transactional
	public Error deleteBatchInvoiceRecord(List<String> ids, String modifiedBy) {
		ErrorInfo er = new ErrorInfo();
		for (String id : ids) {
			if (id == null) {
				return er.getFailRequire("发票记录id");
			}
			int del = invoicerecorddao.deleteInvoiceRecord(id, modifiedBy, new Date());
			if (del == 0) {
				return er.notFoundInvoiceRecord(id);
			}
		}
		return er.findOK();
	}

	// 更新发票记录
	@Override
	@Transactional
	public InvoiceRecord updateInvoiceRecord(String id, InvoiceRecord invrecord) {
		InvoiceRecordDto invdto = invoicerecorddao.findByIdAndStatus(id, "0");
		if (invdto != null) {
			if(invrecord.getClientAddress()!=null){
				invdto.setClientAddress(invrecord.getClientAddress());
			}
			if(invrecord.getClientBankAccount()!=null){
				invdto.setClientBankAccount(invrecord.getClientBankAccount());
			}
			if(invrecord.getClientBankFullName()!=null){
				invdto.setClientBankFullName(invrecord.getClientBankFullName());
			}
			if(invrecord.getClientFullName()!=null){
				invdto.setClientFullName(invrecord.getClientFullName());
			}
			if(invrecord.getModifiedByName()!=null){
				invdto.setModifiedByName(invrecord.getModifiedByName());
			}
			if(invrecord.getDutyNumber()!=null){
				invdto.setDutyNumber(invrecord.getDutyNumber());
			}
			if(invrecord.getInvoiceType()!=null){
				invdto.setInvoiceType(invrecord.getInvoiceType());
			}
			if(invrecord.getOrderCode()!=null){
				invdto.setOrderCode(invrecord.getOrderCode());
			}
			if(invrecord.getPhone()!=null){
				invdto.setPhone(invrecord.getPhone());
			}
			if(invrecord.getRecordCode()!=null){
				invdto.setRecordCode(invrecord.getRecordCode());
			}
			if(invrecord.getRemark()!=null){
				invdto.setRemark(invrecord.getRemark());
			}
			if(invrecord.getSubInvoicePrice()!=null){
				invdto.setSubInvoicePrice(invrecord.getSubInvoicePrice());
			}
			if(invrecord.getTaxRate()!=null){
				invdto.setTaxRate(invrecord.getTaxRate());
			}
			invdto.setModifiedAt(new Date());
			invdto.setModifiedBy(invrecord.getModifiedBy());

			InvoiceRecordDto in = invoicerecorddao.save(invdto);
			if (in != null) {
				return getInvoiceRecord(invrecord,in);
			}
		}
		return null;
	}

	// 根据id查询发票记录信息
	@Override
	public InvoiceRecord getInvoiceRecordById(String id) {
		InvoiceRecordDto record = invoicerecorddao.findByIdAndStatus(id, "0");
		if (record != null) {
			InvoiceRecord invrecord = new InvoiceRecord();
			return getInvoiceRecord(invrecord,record);
		}
		return null;
	}

	public InvoiceRecord getInvoiceRecord(InvoiceRecord invrecord,InvoiceRecordDto record){
		invrecord.setClientAddress(record.getClientAddress());
		invrecord.setClientBankAccount(record.getClientBankAccount());
		invrecord.setClientBankFullName(record.getClientBankFullName());
		invrecord.setClientFullName(record.getClientFullName());
		invrecord.setCreatedAt(record.getCreatedAt());
		invrecord.setCreatedBy(record.getCreatedBy());
		invrecord.setCreatedByName(record.getCreatedByName());
		invrecord.setDutyNumber(record.getDutyNumber());
		invrecord.setId(record.getId());
		invrecord.setInvoiceid(record.getInvoiceid());
		invrecord.setInvoiceType(record.getInvoiceType());
		invrecord.setModifiedAt(record.getModifiedAt());
		invrecord.setModifiedBy(record.getModifiedBy());
		invrecord.setModifiedByName(record.getModifiedByName());
		invrecord.setOrderCode(record.getOrderCode());
		invrecord.setPhone(record.getPhone());
		invrecord.setRecordCode(record.getRecordCode());
		invrecord.setRecordStatus(record.getRecordStatus());
		invrecord.setRemark(record.getRemark());
		invrecord.setSubInvoicePrice(record.getSubInvoicePrice());
		invrecord.setTaxRate(record.getTaxRate());
		
		return invrecord;
	}
	
	
	
	// 分页查询
	@SuppressWarnings("unchecked")
	@Override
	public InvoiceRecordPagableResult getPagableByPram(Integer page, Integer pageSize, String clientFullName,
			String recordStatus) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 99;
		}

		Pageable pageable = new PageRequest(page - 1, pageSize);

		Specification<InvoiceRecordDto> spec = getWhereInvoiceRecord(clientFullName, recordStatus);
		Page<InvoiceRecordDto> pe = invoicerecorddao.findAll(spec, pageable);

		InvoiceRecordPagableResult recordpage = new InvoiceRecordPagableResult();
		recordpage.setInvoiceRecordList(pe.getContent());
		recordpage.setTotalElements(pe.getTotalElements());
		recordpage.setTotalPages((long) pe.getTotalPages());
		return recordpage;
	}

	@SuppressWarnings("rawtypes")
	public Specification getWhereInvoiceRecord(String clientFullName, String recordStatus) {
		return new Specification<InvoiceRecordDto>() {
			public Predicate toPredicate(Root<InvoiceRecordDto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (clientFullName != null && !clientFullName.isEmpty()) {
					list.add(cb.like(root.get("clientFullName").as(String.class), "%" + clientFullName + "%"));
				}
				if (recordStatus != null && !recordStatus.isEmpty()) {
					list.add(cb.like(root.get("recordStatus").as(String.class), "%" + recordStatus + "%"));
				}

				list.add(cb.equal(root.get("status").as(String.class), "0"));

				Predicate[] p = new Predicate[list.size()];
				query.where(cb.and(list.toArray(p)));

//				if (sortName != null && !sortName.isEmpty() && sort != null && !sort.isEmpty()) {
//					if (sortName.contains("At") && sort.equals("desc")) {
//						query.orderBy(cb.desc(root.get(sortName).as(Date.class)));
//					} else if (sortName.contains("At") && sort.equals("asc")) {
//						query.orderBy(cb.asc(root.get(sortName).as(Date.class)));
//					} else if (!sortName.contains("At") && sort.equals("desc")) {
//						query.orderBy(cb.desc(root.get(sortName).as(String.class)));
//					} else if (!sortName.contains("At") && sort.equals("asc")) {
//						query.orderBy(cb.asc(root.get(sortName).as(String.class)));
//					}
//				} else {
				query.orderBy(cb.desc(root.get("createdAt").as(Date.class)));
//				}

				return query.getRestriction();
			}
		};
	}

	// 根据id，查询完整信息
	@Override
	public InvoiceRecordInfo getInvoiceRecordInfoById(String id) {
		InvoiceRecordInfo irinfo = new InvoiceRecordInfo();
		List<ProcessInfo> pinfo = null;
		InvoiceRecordDto invoiceRecord = invoicerecorddao.findByIdAndStatus(id, "0");
		List<InvRecordItemDto> invitem = recorditemdao.findByRecordidAndStatus(id, "0");
		List<InvRecordAssyDto> invassy = recordassydao.findByRecordidAndStatus(id, "0");
		try {
			pinfo = processservice.getProcessDetail(id);
		} catch (Exception e) {
			pinfo = null;
		}
		irinfo.setInvoiceRecord(invoiceRecord);
		irinfo.setInvoiceAssy(invassy);
		irinfo.setInvoiceItem(invitem);
		irinfo.setInvoiceProcess(pinfo);
		return irinfo;
	}

	// 根据id查询流程信息
	@Override
	public RecordProcess getRecordProcessById(String id) {
		RecordProcess recordpro = new RecordProcess();
		InvoiceRecordDto invoiceRecord = invoicerecorddao.findByIdAndStatus(id, "0");
		List<ProcessInfo> pinfo = null;
		try {
			pinfo = processservice.getProcessDetail(id);
		} catch (Exception e) {
			pinfo = null;
		}
		recordpro.setInvoiceRecord(invoiceRecord);
		recordpro.setRecordProcess(pinfo);

		return recordpro;
	}

	// 根据发票id查询发票记录
	@Override
	public List<InvoiceRecordDto> getInvoiceRecordByInvoiceid(String invoiceid) {
		return invoicerecorddao.findByInvoiceidAndStatus(invoiceid, "0");
	}

	@Override
	@Transactional
	public int updateRecordStatus(String id, String recordStatus, String modifiedBy) {
		return invoicerecorddao.updateInvoiceRecordStatus(id, recordStatus, modifiedBy, new Date());
	}

	@Override
	@Transactional
	public Error updateBatchRecordStatus(List<InvoiceRecord> ids) {
		ErrorInfo er = new ErrorInfo();
		for (InvoiceRecord record : ids) {
			if (record.getId() == null) {
				return er.getFailRequire("发票记录id");
			}
			if (record.getModifiedBy() == null) {
				return er.getFailRequire("修改者");
			}
			if (record.getRecordStatus() == null) {
				return er.getFailRequire("发票记录状态");
			}
			int update = invoicerecorddao.updateInvoiceRecordStatus(record.getId(), record.getRecordStatus(),
					record.getModifiedBy(), new Date());
			if (update == 0) {
				return er.notFoundInvoiceRecord(record.getId());
			}
		}
		return er.findOK();
	}

	//自定义查询
	@Override
	public InvoiceRecordPagableResult findInvoiceRecordBySearch(Integer page, Integer pageSize, QuerySortModel definedsearch) {
		if(page==null){
			page = 1;
		}
		if(pageSize == null){
			pageSize=99;
		}
		return invoicerecorddaoimpl.getInvoiceRecordResult(page, pageSize, definedsearch);
	}

	//判断前端输入是否合法
		@Override
		public Error findByQuerySort(QuerySortModel querysort) {
			if(querysort.getQuerys()!=null){
				List<?> querys = querysort.getQuerys();
				Error ex = JudgeChild(querys);
				if (ex != null){
					return ex;
				}
			}

			if (querysort.getSort() != null) {
				SortModel sort = querysort.getSort();
				String ordername = st.judgeParam(column, sort.getName());
				if (ordername != null) {
					return er.notFoundParam("排序名称", ordername);
				}
				String so = st.judgeParam(SerialTool.ordersort, sort.getSort());
				if (so != null) {
					return er.notFoundParam("排序方式", so);
				}
			}
			return null;
		}
		
		
		//自定义查询，递归判断
			public Error JudgeChild(Object query){
				Error ee = er.getError();
				if(ee.getCode() != null && ee.getCode().equals("null")) {
					er.setError(null,null);
					return ee;
				}
				if (query.getClass().getSimpleName().equals("ArrayList")) {
					List<?> qq = (List<?>) query;
					for (Object qx : qq) {
						Error e = JudgeChild(qx);
						if(e!=null){
							return e;
						}
					}
				} else {
					if(query.toString().length()>2){
						Error e = paramChild(query);
						if(e!=null){
							return e;
						}
					}
				}
				return null;
			}
			
			//判断输入的值是否符合规定的值
			@SuppressWarnings("rawtypes")
			public Error paramChild(Object query){
				//1、hashmap to json
				String s = SerialTool.hashMapToJson((HashMap) query);
				JSONObject jobj = new JSONObject(s);
				QueryModel q = new QueryModel();
				q.setColumn(jobj.getString("column"));
				q.setJoin(jobj.getString("join"));
				q.setQuery(jobj.getString("query"));
				q.setValue(jobj.getString("value"));
				// 2、判断列名是否符合规定
				String co = st.judgeParam(column, q.getColumn());
				if (co != null) {
					return er.notFoundParam("列名", co);
				}
				// 3、判断查询方式是否符合规定
				String qy = st.judgeParam(SerialTool.quy, q.getQuery());
				if (qy != null) {
					return er.notFoundParam("查询方式", qy);
				}
				// 4、判断连接方式是否符合规定
				String jo = st.judgeParam(SerialTool.join, q.getJoin());
				if (jo != null) {
					return er.notFoundParam("联结方式", jo);
				}
				return null;
			}

}
