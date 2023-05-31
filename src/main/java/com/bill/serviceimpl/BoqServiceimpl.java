package com.bill.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bill.entity.Boq;
import com.bill.repository.BoqRepository;
import com.bill.request.BoqRequest;
import com.bill.response.BoqResponse;
import com.bill.service.BoqService;
import com.bill.transformer.RequestConverter;
import com.bill.transformer.ResponseConverter;

@Component
public class BoqServiceimpl implements BoqService {

	@Autowired
	private BoqRepository boqRepository;

	@Autowired
	private ResponseConverter responseConverter;

	@Autowired
	private RequestConverter requestConverter;

	public List<BoqResponse> getAllbill() {
		return responseConverter.toBoqResponseList(boqRepository.findAll());

	}

	@Override
	public String saveBill(BoqRequest boqRequest) {
		Boq boqEntity = requestConverter.toBoqModel(boqRequest);

		boqRepository.save(boqEntity);
		return "Saved";
	}

	@Override
	public BoqResponse getById(Long id) {
		Boq model = boqRepository.findById(id).get();
		return responseConverter.entityToBoqResponse(model);
	}

	@Override
	public String deleteBoq(Long id) {

		Optional<Boq> model = boqRepository.findById(id);
		if (model.isPresent()) {

			boqRepository.deleteById(id);

			return "Deleted";

		} else {

			return "Entity not found error";

		}

	}
}
