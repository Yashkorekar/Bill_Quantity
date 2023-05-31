package com.bill.response;

import lombok.Data;

@Data
public class BoqResponse {

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
