package com.bill.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bill.request.BoqRequest;


@Service
public interface ExcelService {

	public String saveexcel(BoqRequest boqRequest) ;
	public String saveAll(MultipartFile file);
}
