package com.bill.transformer;

import org.springframework.stereotype.Component;

import com.bill.entity.Boq;
import com.bill.request.BoqRequest;

@Component
public class RequestConverter {

	public Boq toBoqModel(BoqRequest boqRequest) {

		if (boqRequest == null) {
			return null;
		}
		Boq boqModel = new Boq();

		boqModel.setId(boqRequest.getId());
		boqModel.setItemDescription(boqRequest.getItemDescription());
		boqModel.setHeight(boqRequest.getHeight());
		boqModel.setLength(boqRequest.getLength());
		boqModel.setWidth(boqRequest.getWidth());
		boqModel.setRate(boqRequest.getRate());
		boqModel.setTotalAmount(boqRequest.getHeight() * boqRequest.getLength() * boqRequest.getWidth() );
		boqModel.setTotalMeasurement(boqRequest.getRate() * boqRequest.getUnit());
		boqModel.setUnit(boqRequest.getUnit());

		return boqModel;

	}

}
