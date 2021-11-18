package com.sap.demo.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sap.demo.pojo.SapItem;
import com.sap.demo.repo.ItemRepository;

@RestController
//@RequestMapping("/items")
public class SapController {
	@Autowired
	private ItemRepository repo;

	// Get Method to Fetch the data
	@RequestMapping(method = RequestMethod.GET, value = "/items")
	public List<SapItem> getAllItems() {
		LocalDateTime now = LocalDateTime.now();
		Timestamp timeStampCurrent = Timestamp.valueOf(now);
		Timestamp timestamp2sBefore = Timestamp.valueOf(now.minusSeconds(2));
		List<SapItem> li = repo.findTimeStamp(timestamp2sBefore, timeStampCurrent);
		if (li.size() > 100) {
			return li;
		} else {

			return repo.findAll().stream().limit(100).collect(Collectors.toList());

		}
	}

	// Post method to save the data
	@RequestMapping(method = RequestMethod.POST, value = "/items")
	public ResponseEntity<SapItem> addAllItems(@RequestBody SapItem item) {
		System.out.print(item.getId());
		System.out.print(item.getTimeStamp());
		repo.save(item);
		System.out.println(item);
		return new ResponseEntity<SapItem>(HttpStatus.CREATED);
	}

}
