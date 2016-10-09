package com.yimym.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.yimym.dto.InvRecordAssyDto;

public interface RecordAssyDao extends JpaRepository<InvRecordAssyDto,String>{
	InvRecordAssyDto findByIdAndStatus(String id,String status);

	@Modifying
	@Query("update InvRecordAssyDto set status = 1 ,modifiedBy = ?2, modifiedAt=?3 where id=?1 and status=0")
	int deleteRecordAssy(String id,String modifiedBy,Date modifiedAt);
	
	Page<InvRecordAssyDto> findAll(Specification<InvRecordAssyDto> spec, Pageable pageable);
	
	List<InvRecordAssyDto> findByRecordidAndStatus(String recordid,String status);
	
	//根据recordid进行删除
	@Modifying
	@Query("update InvRecordAssyDto set status = 1 ,modifiedBy = ?2, modifiedAt=?3 where recordid=?1 and status=0")
	int deleteRecordAssyByRecordid(String recordid,String modifiedBy,Date modifiedAt);
}
