package com.yimym.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yimym.dto.InvoiceRecordDto;

public interface InvoiceRecordDao extends JpaRepository<InvoiceRecordDto,String>{
	InvoiceRecordDto findByIdAndStatus(String id,String status);

	@Modifying
	@Query("update InvoiceRecordDto set status = 1 ,modifiedBy = ?2, modifiedAt=?3 where id=?1 and status=0")
	int deleteInvoiceRecord(String id,String modifiedBy,Date modifiedAt);
	
	List<InvoiceRecordDto> findByInvoiceidAndStatus(String invoiceid,String status);
	
	Page<InvoiceRecordDto> findAll(Specification<InvoiceRecordDto> spec, Pageable pageable);
	
	
	@Modifying
	@Query("update InvoiceRecordDto set recordStatus = ?2 ,modifiedBy = ?3, modifiedAt=?4 where id=?1 and status=0")
	int updateInvoiceRecordStatus(String id,String recordStatus,String modifiedBy,Date modifiedAt);
}
