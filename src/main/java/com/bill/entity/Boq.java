package com.bill.entity;

import java.io.Serializable;

import org.hibernate.annotations.Formula;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "BOQ")
public class Boq  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item Id")
	private Long id;

	@Column(name = "item description")
	private String itemDescription;

	@Column(name = "length")
	private Long length;

	@Column(name = "width")
	private Long width;

	@Column(name = "height")
	private Long height;
	
	@Column(name = "total measurement")
	//@Formula("length * width")
	private Long totalMeasurement;

	@Column(name = "unit")
	private Long unit;

	@Column(name = "rate")
	private Long rate;

	@Column(name = "total amount")
	private Long totalAmount;

}
