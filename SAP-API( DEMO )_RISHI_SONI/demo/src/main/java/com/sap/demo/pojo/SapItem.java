package com.sap.demo.pojo;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sapItem")

public class SapItem {
	@Id
	private Long id;
	private Timestamp timeStamp;

	public SapItem() {
	}

	public SapItem(Long id, Timestamp timeStamp) {
		super();
		this.id = id;
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

}
