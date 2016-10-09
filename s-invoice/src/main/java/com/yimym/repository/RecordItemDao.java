package com.yimym.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yimym.dto.InvRecordItemDto;

public interface RecordItemDao extends JpaRepository<InvRecordItemDto,String> {
	InvRecordItemDto findByIdAndStatus(String id,String status);

	@Modifying
	@Query("update InvRecordItemDto set status = 1 ,modifiedBy = ?2, modifiedAt=?3 where id=?1 and status=0")
	int deleteRecordItem(String id,String modifiedBy,Date modifiedAt);
	
	List<InvRecordItemDto> findByRecordidAndStatus(String recordid,String status);
	
	Page<InvRecordItemDto> findAll(Specification<InvRecordItemDto> spec, Pageable pageable);
}
