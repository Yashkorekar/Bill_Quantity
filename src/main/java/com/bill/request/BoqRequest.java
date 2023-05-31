package com.bill.request;

import lombok.Data;

@Data
public class BoqRequest {

	private Long id;

	private String itemDescription;

	private Long length;

	private Long width;

	private Long height;

	private Long totalMeasurement;

	private Long unit;

	private Long rate;

	private Long totalAmount;
}
