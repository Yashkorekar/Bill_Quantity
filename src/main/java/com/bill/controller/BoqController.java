package com.bill.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bill.request.BoqRequest;
import com.bill.response.BoqResponse;
import com.bill.service.BoqService;

@RestController
@RequestMapping("/boq")
public class BoqController {

	@Autowired
	BoqService boqService;

	@GetMapping
	public List<BoqResponse> getAllbill() {
		return boqService.getAllbill();
	}

	@PostMapping("/save")
	public ResponseEntity<String> saveBoqDetails(@RequestBody BoqRequest boqRequest) {

		return ResponseEntity.ok(boqService.saveBill(boqRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<BoqResponse> getById(@PathVariable Long id) {

		return ResponseEntity.ok(boqService.getById(id));
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBoq(@PathVariable Long id) {
		boqService.deleteBoq(id);
		return "deleted";
	}

}
