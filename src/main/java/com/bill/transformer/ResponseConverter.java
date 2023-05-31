package com.bill.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.bill.entity.Boq;
import com.bill.response.BoqResponse;




@Component
public class ResponseConverter {
	
	
	public BoqResponse entityToBoqResponse(Boq boqEntity) {
		   
		BoqResponse boqResponse = new BoqResponse();
		 
		boqResponse.setId(boqEntity.getId());
		boqResponse.setItemDescription(boqEntity.getItemDescription());
		boqResponse.setHeight(boqEntity.getHeight());
		boqResponse.setLength(boqEntity.getLength());
		boqResponse.setWidth(boqEntity.getWidth());
		boqResponse.setTotalMeasurement(boqEntity.getTotalMeasurement());
		boqResponse.setRate(boqEntity.getRate());
		boqResponse.setUnit(boqEntity.getUnit());
		boqResponse.setTotalAmount(boqEntity.getTotalAmount());
		   
		   return boqResponse;
	   }
	   
	 public List<BoqResponse> toBoqResponseList(List<Boq> boqEntityList){
		   
		   return boqEntityList.stream().map(boq-> entityToBoqResponse(boq)).collect(Collectors.toList());
	   }
	   
	

}
