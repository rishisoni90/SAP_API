package com.sap.demo.repo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sap.demo.pojo.SapItem;

@Repository
public interface ItemRepository extends JpaRepository<SapItem, Long> {

	@Query("select s from SapItem s where s.timeStamp BETWEEN ?1 AND ?2")
	List<SapItem> findTimeStamp(Timestamp timestamp2sBefore, Timestamp timeStampCurrent);
}