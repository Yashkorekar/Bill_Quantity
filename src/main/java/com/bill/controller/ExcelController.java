package com.bill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bill.request.BoqRequest;
import com.bill.service.ExcelService;


@RestController
@RequestMapping("excel")
public class ExcelController {
	
	@Autowired
	ExcelService excelService;
	
	@PostMapping("/save")
	public String saveexcel(@RequestBody BoqRequest boqRequest) {
		
		return excelService.saveexcel(boqRequest);
	}

	@PostMapping(path="/upload/excel")
	public String addUsersFromExcel(@RequestParam("file") MultipartFile file){
		
		return excelService.saveAll(file);
	}

}
