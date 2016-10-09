package com.yimym.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.yimym.dto.InvRecordItemDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.RecordItem;
import com.yimym.model.RecordItemPagableResult;
import com.yimym.repository.RecordItemDao;
import com.yimym.util.SerialTool;

@Service
public class RecordItemServiceImpl implements RecordItemService {

	@Autowired
	RecordItemDao recorditemdao;
	//新增开票明细
	@Override
	@Transactional
	public RecordItem createRecordItem(String recordid, RecordItem recorditem) {
		InvRecordItemDto item = new InvRecordItemDto();
		item.setId(new SerialTool().getUUID());
		item.setCreatedAt(new Date());
		item.setCreatedBy(recorditem.getCreatedBy());
		item.setItemCode(recorditem.getItemCode());
		item.setItemName(recorditem.getItemName());
		item.setItemNum(recorditem.getItemNum());
		item.setOrderitemNum(recorditem.getOrderitemNum());
		item.setPlusDutyPrice(recorditem.getPlusDutyPrice());
		item.setPrice(recorditem.getPrice());
		item.setRecordid(recordid);
		item.setRemark(recorditem.getRemark());
		item.setSpec(recorditem.getSpec());
		item.setStatus("0");
		item.setUnit(recorditem.getUnit());
		
		InvRecordItemDto in = recorditemdao.save(item);
		if(in!=null){
			recorditem.setId(in.getId());
			recorditem.setRecordid(in.getRecordid());
			recorditem.setCreatedAt(in.getCreatedAt());
			return recorditem;
		}
		return null;
	}

	//删除开票明细
	@Override
	@Transactional
	public int deleteRecordItem(String id, String modifiedBy) {
		return recorditemdao.deleteRecordItem(id, modifiedBy, new Date());
	}

	//批量删除开票明细
	@Override
	@Transactional
	public Error deleteBatchRecordItem(List<String> ids, String modifiedBy) {
		ErrorInfo er = new ErrorInfo();
		for (String id : ids) {
			if (id == null) {
				return er.getFailRequire("发票明细id");
			}
			
			int del = recorditemdao.deleteRecordItem(id,modifiedBy, new Date());
			if (del == 0) {
				return er.notFoundRecordItem(id);
			}
		}
		return er.findOK();
	}

	//更新发票明细
	@Override
	@Transactional
	public RecordItem updateRecordItem(String id, RecordItem recorditem) {
		InvRecordItemDto item = recorditemdao.findByIdAndStatus(id, "0");
		if(item!=null){
			if(recorditem.getItemCode()!=null){
				item.setItemCode(recorditem.getItemCode());
			}
			if(recorditem.getItemName()!=null){
				item.setItemName(recorditem.getItemName());
			}
			if(recorditem.getItemNum()!=null){
				item.setItemNum(recorditem.getItemNum());
			}
			if(recorditem.getOrderitemNum()!=null){
				item.setOrderitemNum(recorditem.getOrderitemNum());
			}
			if(recorditem.getPlusDutyPrice()!=null){
				item.setPlusDutyPrice(recorditem.getPlusDutyPrice());
			}
			if(recorditem.getPrice()!=null){
				item.setPrice(recorditem.getPrice());
			}
			if(recorditem.getRemark()!=null){
				item.setRemark(recorditem.getRemark());
			}
			if(recorditem.getSpec()!=null){
				item.setSpec(recorditem.getSpec());
			}
			if(recorditem.getUnit()!=null){
				item.setUnit(recorditem.getUnit());
			}
			
			item.setModifiedAt(new Date());
			item.setModifiedBy(recorditem.getModifiedBy());
			
			InvRecordItemDto in = recorditemdao.save(item);
			if(in!=null){
				return getRecordItem(recorditem,item);
			}
		}
		return null;
	}

	//根据id查询开票明细
	@Override
	public RecordItem getRecordItemById(String id) {
		RecordItem recorditem = new RecordItem();
		InvRecordItemDto item = recorditemdao.findByIdAndStatus(id, "0");
		if(item!=null){
			return getRecordItem(recorditem,item);
		}
		return null;
		
	}

	public RecordItem getRecordItem(RecordItem recorditem,InvRecordItemDto item){
		recorditem.setCreatedAt(item.getCreatedAt());
		recorditem.setCreatedBy(item.getCreatedBy());
		recorditem.setId(item.getId());
		recorditem.setRecordid(item.getRecordid());
		recorditem.setModifiedAt(item.getModifiedAt());
		recorditem.setModifiedBy(item.getModifiedBy());
		recorditem.setItemCode(item.getItemCode());
		recorditem.setItemName(item.getItemName());
		recorditem.setItemNum(item.getItemNum());
		recorditem.setOrderitemNum(item.getOrderitemNum());
		recorditem.setPlusDutyPrice(item.getPlusDutyPrice());
		recorditem.setPrice(item.getPrice());
		recorditem.setRecordid(item.getRecordid());
		recorditem.setRemark(item.getRemark());
		recorditem.setSpec(item.getSpec());
		recorditem.setUnit(item.getUnit());
		
		return recorditem;
	}
	
	//开票明细分页查询
	@SuppressWarnings("unchecked")
	@Override
	public RecordItemPagableResult getPagableByPram(Integer page, Integer pageSize, String itemName) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 99;
		}

		Pageable pageable = new PageRequest(page - 1, pageSize);

		Specification<InvRecordItemDto> spec = getWhereInvoiceItem(itemName);
		Page<InvRecordItemDto> pe = recorditemdao.findAll(spec, pageable);

		RecordItemPagableResult itempage = new RecordItemPagableResult();
		itempage.setRecordItemList(pe.getContent());
		itempage.setTotalElements(pe.getTotalElements());
		itempage.setTotalPages((long)pe.getTotalPages());
		return itempage;
	}
	
	@SuppressWarnings("rawtypes")
	public Specification getWhereInvoiceItem(String itemName) {
		return new Specification<InvRecordItemDto>() {
			public Predicate toPredicate(Root<InvRecordItemDto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				
				if (itemName!=null && !itemName.isEmpty()) {
					list.add(cb.like(root.get("itemName").as(String.class), "%" + itemName + "%"));
				}

				list.add(cb.equal(root.get("status").as(String.class), "0"));

				Predicate[] p = new Predicate[list.size()];
				query.where(cb.and(list.toArray(p)));

				query.orderBy(cb.desc(root.get("createdAt").as(Date.class)));
				
				return query.getRestriction();
			}
		};
	}


	//根据recoidid查询明细
	@Override
	public List<InvRecordItemDto> getRecordItemByRecordid(String recordid) {
		return recorditemdao.findByRecordidAndStatus(recordid, "0");
	}

}
