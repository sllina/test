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

import com.yimym.dto.InvRecordAssyDto;
import com.yimym.model.Error;
import com.yimym.model.ErrorInfo;
import com.yimym.model.RecordAssy;
import com.yimym.model.RecordAssyPagableResult;
import com.yimym.repository.RecordAssyDao;
import com.yimym.util.SerialTool;

@Service
public class RecordAssyServiceImpl implements RecordAssyService {

	@Autowired
	RecordAssyDao recordassydao;
	//新增开票记录
	@Override
	@Transactional
	public RecordAssy createRecordAssy(String recordid, RecordAssy recordassy) {
		InvRecordAssyDto invdto = new InvRecordAssyDto();
		invdto.setId(new SerialTool().getUUID());
		invdto.setAssyid(recordassy.getAssyid());
		invdto.setAssyName(recordassy.getAssyName());
		invdto.setAssyUrl(recordassy.getAssyUrl());
		invdto.setCreatedAt(new Date());
		invdto.setCreatedBy(recordassy.getCreatedBy());
		invdto.setDescription(recordassy.getDescription());
		invdto.setRecordid(recordid);
		invdto.setStatus("0");
		
		InvRecordAssyDto in = recordassydao.save(invdto);
		if(in!=null){
			recordassy.setId(in.getId());
			recordassy.setCreatedAt(in.getCreatedAt());
			recordassy.setRecordid(in.getRecordid());
			
			return recordassy;
		}
		return null;
	}

	//删除开票记录
	@Override
	@Transactional
	public int deleteRecordAssy(String id, String modifiedBy) {
		return recordassydao.deleteRecordAssy(id, modifiedBy, new Date());
	}

	//批量删除开票记录
	@Override
	@Transactional
	public Error deleteBatchRecordAssy(List<String> ids, String modifiedBy) {
		ErrorInfo er = new ErrorInfo();
		for (String id : ids) {
			if (id == null) {
				return er.getFailRequire("发票附件id");
			}
			
			int del = recordassydao.deleteRecordAssy(id,modifiedBy, new Date());
			if (del == 0) {
				return er.notFoundRecordAssy(id);
			}
		}
		return er.findOK();
	}

	//更新开票记录
	@Override
	@Transactional
	public RecordAssy updateRecordAssy(String id, RecordAssy recordassy) {
		InvRecordAssyDto invdto = recordassydao.findByIdAndStatus(id, "0");
		if(invdto!=null){
			if(recordassy.getAssyid()!=null){
				invdto.setAssyid(recordassy.getAssyid());
			}
			if(recordassy.getAssyName()!=null){
				invdto.setAssyName(recordassy.getAssyName());
			}
			if(recordassy.getAssyUrl()!=null){
				invdto.setAssyUrl(recordassy.getAssyUrl());
			}
			if(recordassy.getDescription()!=null){
				invdto.setDescription(recordassy.getDescription());
			}
			invdto.setModifiedAt(new Date());
			invdto.setModifiedBy(recordassy.getModifiedBy());
			
			InvRecordAssyDto in = recordassydao.save(invdto);
			if(in!=null){
				return getRecordAssy(recordassy,invdto);
			}
			
		}
		return null;
	}

	//根据i得到开票记录
	@Override
	public RecordAssy getRecordAssyById(String id) {
		InvRecordAssyDto invdto = recordassydao.findByIdAndStatus(id, "0");
		RecordAssy assy = new RecordAssy();
		if(invdto != null){
			return getRecordAssy(assy,invdto);
		}
		return null;
	}
	
	public RecordAssy getRecordAssy(RecordAssy assy,InvRecordAssyDto invdto){
		assy.setAssyid(invdto.getAssyid());
		assy.setAssyName(invdto.getAssyName());
		assy.setAssyUrl(invdto.getAssyUrl());
		assy.setCreatedAt(invdto.getCreatedAt());
		assy.setCreatedBy(invdto.getCreatedBy());
		assy.setDescription(invdto.getDescription());
		assy.setId(invdto.getId());
		assy.setModifiedAt(invdto.getModifiedAt());
		assy.setModifiedBy(invdto.getModifiedBy());
		assy.setRecordid(invdto.getRecordid());
		
		return assy;
	}

	
	//分页查询
	@SuppressWarnings("unchecked")
	@Override
	public RecordAssyPagableResult getPagableByPram(Integer page, Integer pageSize, String assyName, String sortName,
			String sort) {
		if (page == null) {
			page = 1;
		}
		if (pageSize == null) {
			pageSize = 99;
		}

		Pageable pageable = new PageRequest(page - 1, pageSize);

		Specification<InvRecordAssyDto> spec = getWhereInvoiceItem(assyName,sortName, sort);
		Page<InvRecordAssyDto> pe = recordassydao.findAll(spec, pageable);

		RecordAssyPagableResult assypage = new RecordAssyPagableResult();
		assypage.setRecordAssyList(pe.getContent());
		assypage.setTotalElements(pe.getTotalElements());
		assypage.setTotalPages((long)pe.getTotalPages());
		return assypage;
	}

	@SuppressWarnings("rawtypes")
	public Specification getWhereInvoiceItem(String assyName, String sortName, String sort) {
		return new Specification<InvRecordAssyDto>() {
			public Predicate toPredicate(Root<InvRecordAssyDto> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();
				
				if (assyName!=null && !assyName.isEmpty()) {
					list.add(cb.like(root.get("assyName").as(String.class), "%" + assyName + "%"));
				}

				list.add(cb.equal(root.get("status").as(String.class), "0"));

				Predicate[] p = new Predicate[list.size()];
				query.where(cb.and(list.toArray(p)));

				if(sortName!=null && !sortName.isEmpty() && sort!=null && !sort.isEmpty()){
					if(sortName.contains("At") && sort.equals("desc")){
						query.orderBy(cb.desc(root.get(sortName).as(Date.class)));
					}
					else if(sortName.contains("At") && sort.equals("asc")){
						query.orderBy(cb.asc(root.get(sortName).as(Date.class)));
					}
					else if(!sortName.contains("At") && sort.equals("desc")){
						query.orderBy(cb.desc(root.get(sortName).as(String.class)));
					}
					else if(!sortName.contains("At") && sort.equals("asc")){
						query.orderBy(cb.asc(root.get(sortName).as(String.class)));
					}
				}else{
					query.orderBy(cb.desc(root.get("createdAt").as(Date.class)));
				}
				
				return query.getRestriction();
			}
		};
	}
	
	//根据id查询开票记录
	@Override
	public List<InvRecordAssyDto> getRecordAssyByRecordid(String recordid) {
		return recordassydao.findByRecordidAndStatus(recordid, "0");
	}

	//根据recordid进行删除
	@Override
	@Transactional
	public int deleteAssyByRecordid(String recordid,String modifiedBy) {
		return recordassydao.deleteRecordAssyByRecordid(recordid, modifiedBy, new Date());
	}

}
