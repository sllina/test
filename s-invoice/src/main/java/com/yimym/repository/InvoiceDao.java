package com.yimym.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yimym.dto.InvoiceDto;

public interface InvoiceDao extends JpaRepository<InvoiceDto,String>{
	
	InvoiceDto findByIdAndStatus(String id,String status);
	
	//删除发票信息
	@Modifying
	@Query("update InvoiceDto set status = 1 ,modifiedBy = ?2, modifiedAt=?3 where id=?1 and status=0")
	int deleteInvoice(String id,String modifiedBy,Date modifiedAt);
	
	Page<InvoiceDto> findAll(Specification<InvoiceDto> spec, Pageable pageable);
	
	InvoiceDto findByOrderidAndStatus(String orderid,String status);
	
	//更新发票状态
	@Modifying
	@Query("update InvoiceDto set invoiceStatus = ?2 ,modifiedBy = ?3, modifiedAt=?4 where id=?1 and status=0")
	int updateInvoiceStatus(String id,String status,String modifiedBy,Date modifiedAt);
}
