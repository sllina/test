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

import com.yimym.dto.InvoiceDto;
import com.yimym.dto.InvoiceRecordDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.Invoice;
import com.yimym.model.InvoiceInfo;
import com.yimym.model.InvoicePagableResult;
import com.yimym.model.QueryModel;
import com.yimym.model.QuerySortModel;
import com.yimym.model.SortModel;
import com.yimym.repository.InvoiceDao;
import com.yimym.repository.InvoiceDaoImpl;
import com.yimym.repository.InvoiceRecordDao;
import com.yimym.util.SerialTool;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceDao invoicedao;

	@Autowired
	InvoiceRecordDao invoicerecorddao;

	@Autowired
	InvoiceDaoImpl invoicedaoimpl;

	ErrorInfo er = new ErrorInfo();

	String[] column = {"id","orderid","createdAt","createdBy","turnOver","invoicePrice","invoiceStatus","orderCode","clientid","clientFullName","orderMakerid","orderMakerName","modifiedAt","modifiedBy"};

	private SerialTool st = new SerialTool();

	// 新增发票
	@Override
	@Transactional
	public Invoice createInvoice(String orderid, Invoice invoice) {
		InvoiceDto idto = new InvoiceDto();
		idto.setId(new SerialTool().getUUID());
		idto.setClientFullName(invoice.getClientFullName());
		idto.setClientid(invoice.getClientid());
		idto.setInvoicePrice(invoice.getInvoicePrice());
		idto.setOrderid(orderid);
		idto.setOrderMakerid(invoice.getOrderMakerid());
		idto.setOrderMakerName(invoice.getOrderMakerName());
		idto.setRemark(invoice.getRemark());
		idto.setTurnOver(invoice.getTurnOver());
		idto.setOrderCode(invoice.getOrderCode());
		idto.setInvoiceStatus("0");
		idto.setStatus("0");
		idto.setCreatedBy(invoice.getCreatedBy());
		idto.setCreatedAt(new Date());
		InvoiceDto in = invoicedao.save(idto);
		if (in != null) {
			invoice.setInvoiceStatus(in.getInvoiceStatus());
			invoice.setId(in.getId());
			invoice.setCreatedAt(in.getCreatedAt());
			invoice.setOrderid(in.getOrderid());
			return invoice;
		}
		return null;
	}

	// 删除发票
	@Override
	@Transactional
	public int deleteInvoice(String id, String modifiedBy) {
		int del = invoicedao.deleteInvoice(id, modifiedBy, new Date());
		return del;
	}

	// 批量删除发票
	@Override
	@Transactional
	public Error deleteBatchInvoice(List<String> ids, String modifiedBy) {
		ErrorInfo er = new ErrorInfo();
		for (String id : ids) {
			if (id == null) {
				return er.getFailRequire("发票id");
			}

			int del = invoicedao.deleteInvoice(id, modifiedBy, new Date());
			if (del == 0) {
				return er.notFoundID(id);
			}
		}
		return er.findOK();
	}

	// 更新发票
	@Override
	@Transactional
	public Invoice updateInvoice(String id, Invoice invoice) {
		InvoiceDto idto = invoicedao.findByIdAndStatus(id, "0");
		if (idto != null) {
			if(invoice.getClientFullName()!=null){
				idto.setClientFullName(invoice.getClientFullName());
			}
			if(invoice.getClientid()!=null){
				idto.setClientid(invoice.getClientid());
			}
			if(invoice.getInvoicePrice()!=null){
				idto.setInvoicePrice(invoice.getInvoicePrice());
			}
			if(invoice.getOrderMakerid()!=null){
				idto.setOrderMakerid(invoice.getOrderMakerid());
			}
			if(invoice.getOrderMakerName()!=null){
				idto.setOrderMakerName(invoice.getOrderMakerName());
			}
			if(invoice.getRemark()!=null){
				idto.setRemark(invoice.getRemark());
			}
			if(invoice.getTurnOver()!=null){
				idto.setTurnOver(invoice.getTurnOver());
			}
			if(invoice.getOrderCode()!=null){
				idto.setOrderCode(invoice.getOrderCode());
			}
			idto.setModifiedBy(invoice.getModifiedBy());
			idto.setModifiedAt(new Date());
			InvoiceDto in = invoicedao.save(idto);
			if (in != null) {
				return getInvoice(invoice,in);
			}
		}
		return null;
	}

	// 根据id获取发票信息
	@Override
	public Invoice getInvoiceById(String id) {
		Invoice invoice = new Invoice();
		InvoiceDto in = invoicedao.findByIdAndStatus(id, "0");
		if (in != null) {
			return getInvoice(invoice, in);
		}
		return null;
	}

	public Invoice getInvoice(Invoice invoice, InvoiceDto in) {
		invoice.setId(in.getId());
		invoice.setOrderid(in.getOrderid());
		invoice.setClientFullName(in.getClientFullName());
		invoice.setClientid(in.getClientid());
		invoice.setInvoicePrice(in.getInvoicePrice());
		invoice.setInvoiceStatus(in.getInvoiceStatus());
		invoice.setOrderCode(in.getOrderCode());
		invoice.setOrderMakerid(in.getOrderMakerid());
		invoice.setOrderMakerName(in.getOrderMakerName());
		invoice.setRemark(in.getRemark());
		invoice.setTurnOver(in.getTurnOver());
		invoice.setCreatedBy(in.getCreatedBy());
		invoice.setCreatedAt(in.getCreatedAt());
		invoice.setModifiedBy(in.getModifiedBy());
		invoice.setModifiedAt(in.getModifiedAt());

		return invoice;
	}

	// 条件 分页查询
	@SuppressWarnings("unchecked")
	@Override
	public InvoicePagableResult getPagableByPram(Integer page, Integer pageSize, String orderMakerName,String invoiceStatus) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 99;
		}

		Pageable pageable = new PageRequest(page - 1, pageSize);

		Specification<InvoiceDto> spec = getWhereInvoice(orderMakerName, invoiceStatus);
		Page<InvoiceDto> pe = invoicedao.findAll(spec, pageable);

		InvoicePagableResult invoicepage = new InvoicePagableResult();
		invoicepage.setInvoiceList(pe.getContent());
		invoicepage.setTotalElements(pe.getTotalElements());
		invoicepage.setTotalPages((long) pe.getTotalPages());
		return invoicepage;
	}

	@SuppressWarnings("rawtypes")
	public Specification getWhereInvoice(String orderMakerName, String invoiceStatus) {
		return new Specification<InvoiceDto>() {
			public Predicate toPredicate(Root<InvoiceDto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (orderMakerName != null && !orderMakerName.isEmpty()) {
					list.add(cb.like(root.get("orderMakerName").as(String.class), "%" + orderMakerName + "%"));
				}
				if (invoiceStatus != null && !invoiceStatus.isEmpty()) {
					list.add(cb.like(root.get("invoiceStatus").as(String.class), "%" + invoiceStatus + "%"));
				}

				list.add(cb.equal(root.get("status").as(String.class), "0"));

				Predicate[] p = new Predicate[list.size()];
				query.where(cb.and(list.toArray(p)));

				query.orderBy(cb.desc(root.get("createdAt").as(Date.class)));
				

				return query.getRestriction();
			}
		};
	}

	// 根据id，查询完整信息
	@Override
	public InvoiceInfo getInvoiceInfoById(String id) {
		InvoiceInfo invinfo = new InvoiceInfo();

		InvoiceDto invdto = invoicedao.findByIdAndStatus(id, "0");
		List<InvoiceRecordDto> recdto = invoicerecorddao.findByInvoiceidAndStatus(id, "0");

		invinfo.setInvoice(invdto);
		invinfo.setInvoiceRecord(recdto);
		return invinfo;
	}

	// 根据订单id查询，不完整信息
	@Override
	public InvoiceDto getInvoiceByOrderid(String orderid) {
		return invoicedao.findByOrderidAndStatus(orderid, "0");
	}

	/*// 根据订单id查询，完整信息
	@Override
	public InvoiceInfo getInvoiceInfoByorderid(String orderid) {
		InvoiceInfo info = new InvoiceInfo();
		List<InvoiceDto> invdto = invoicedao.findByOrderidAndStatus(orderid, "0");
		if (invdto != null) {
			List<InvoiceRecordDto> recdto = invoicerecorddao.findByInvoiceidAndStatus(invdto.getId(), "0");
			info.setInvoice(invdto);
			info.setInvoiceRecord(recdto);
			return info;
		}
		return null;
	}*/

	// 更新发票状态，根据id
	@Override
	@Transactional
	public int updateInvoiceStatus(String id, String invoicestatus, String modifiedBy) {
		return invoicedao.updateInvoiceStatus(id, invoicestatus, modifiedBy, new Date());
	}

	// 批量更新状态
	@Override
	@Transactional
	public Error updateBatchInvoiceStatus(List<Invoice> ids) {
		ErrorInfo er = new ErrorInfo();
		for (Invoice invoiceInfo : ids) {
			if (invoiceInfo.getId() == null) {
				return er.getFailRequire("发票id");
			}
			if (invoiceInfo.getModifiedBy() == null) {
				return er.getFailRequire("修改者");
			}
			if (invoiceInfo.getInvoiceStatus() == null) {
				return er.getFailRequire("发票状态");
			}
			int update = invoicedao.updateInvoiceStatus(invoiceInfo.getId(), invoiceInfo.getInvoiceStatus(),
					invoiceInfo.getModifiedBy(), new Date());
			if (update == 0) {
				return er.notFoundID(invoiceInfo.getId());
			}
		}
		return er.findOK();
	}

	// 自定义查询
	@Override
	public InvoicePagableResult findInvoiceBySearch(Integer page, Integer pageSize, QuerySortModel definedsearch) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 99;
		}
		return invoicedaoimpl.getInvoiceResult(page, pageSize, definedsearch);
	}

	// 判断前端输入是否合法
	@Override
	public Error findByQuerySort(QuerySortModel querysort) {
		if(querysort.getQuerys()!=null){
			List<?> querys = querysort.getQuerys();
			Error ex = JudgeChild(querys);
			if (ex != null) {
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

	// 自定义查询，递归判断
	public Error JudgeChild(Object query) {
		Error ee = er.getError();
		if (ee.getCode() != null && ee.getCode().equals("null")) {
			er.setError(null, null);
			return ee;
		}
		if (query.getClass().getSimpleName().equals("ArrayList")) {
			List<?> qq = (List<?>) query;
			for (Object qx : qq) {
				Error e = JudgeChild(qx);
				if (e != null) {
					return e;
				}
			}
		} else {
			if (query.toString().length() > 2) {
				Error e = paramChild(query);
				if (e != null) {
					return e;
				}
			}
		}
		return null;
	}

	// 判断输入的值是否符合规定的值
	@SuppressWarnings("rawtypes")
	public Error paramChild(Object query) {
		// 1、hashmap to json
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
