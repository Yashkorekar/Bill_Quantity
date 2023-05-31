package com.bill.serviceimpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.bill.entity.Boq;
import com.bill.repository.BoqRepository;
import com.bill.request.BoqRequest;
import com.bill.service.ExcelService;
import com.bill.transformer.ExcelConverter;
import com.bill.transformer.RequestConverter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ExcelServiceimpl implements ExcelService{
	
	@Autowired
	BoqRepository boqRepository;
	
	@Autowired
	RequestConverter requestConverter;
	
	@Autowired
	ExcelConverter excelConverter;

	@Override
	public String saveexcel(BoqRequest boqRequest) {
		Boq boqModel = requestConverter.toBoqModel(boqRequest);
		boqRepository.save(boqModel);
		return "saved";
	}

	@Override
	public String saveAll(MultipartFile file) {
		long startTime = System.currentTimeMillis();
		try {
			List<BoqRequest> boqRequestList = excelConverter.exceltoUserModelList(file.getInputStream());
			List<Boq> boqModelList = new ArrayList<Boq>();
			for(BoqRequest customer : boqRequestList) {
				boqModelList.add(requestConverter.toBoqModel(customer));
			}
			boqRepository.saveAll(boqModelList);
			long endTime = System.currentTimeMillis();
	        long uploadTime = endTime - startTime;
	        log.info(" uploadTime :{}",uploadTime);
			return "saved";
			
		} catch (IOException e) {

			e.printStackTrace();
			return null;
		}
	}

}
