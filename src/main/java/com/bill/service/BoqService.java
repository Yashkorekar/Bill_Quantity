package com.bill.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bill.request.BoqRequest;
import com.bill.response.BoqResponse;

@Service
public interface BoqService {

	public List<BoqResponse> getAllbill();

	public String saveBill(BoqRequest boqRequest);

	public BoqResponse getById(Long id);

	public String deleteBoq(Long id);

}
