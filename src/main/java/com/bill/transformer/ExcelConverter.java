package com.bill.transformer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.bill.request.BoqRequest;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ExcelConverter {

	public List<BoqRequest> exceltoUserModelList(InputStream excelFileInputStream) {
		
		 

		List<BoqRequest> boqRequestList = new ArrayList<>();

		try (XSSFWorkbook workbook = new XSSFWorkbook(excelFileInputStream)) {

			XSSFSheet sheet = workbook.getSheet("sheet1");

			Iterator<Row> rowIterator = sheet.rowIterator();

			int rowNumber = 0;

			while (rowIterator.hasNext()) {

				Row row = rowIterator.next();

				Iterator<Cell> cellCheck = row.cellIterator();

				Boolean isRowEmpty = true;

				while (cellCheck.hasNext()) {
					Cell flagCell = cellCheck.next();
					if (flagCell.getCellType() != CellType.BLANK) {
						isRowEmpty = false;
						break;
					}
				}

//				if ("end".equals(row.getCell(1).getStringCellValue())) {
//					break;
//				}

				Iterator<Cell> cellIterator = row.cellIterator();
				Integer cellId = 0;

				BoqRequest boqRequest = new BoqRequest();

				Long length = null;
				Long width = null;
				Long height = null;
				Long unit = null;
				Long rate = null;
				Long id = null;
				String itemDescription = null;

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();

					switch (cellId) {

//					case 0: {
//
//						itemDescription = cell.getStringCellValue();
//						log.info("run");
//						break;
//
//					}
					case 0: {

						length = (long) cell.getNumericCellValue();
						log.info("run");
						break;

					}
					case 1: {

						width = (long) cell.getNumericCellValue();
						log.info("run");
						break;
					}
					case 2: {

						height = (long) cell.getNumericCellValue();
						log.info("run");
						break;
					}
					case 3: {
						unit = (long) cell.getNumericCellValue();
						log.info("run");
						break;

					}

					case 4: {

						rate = (long) cell.getNumericCellValue();
						log.info("run");
						break;

					}
					case 5: {

						id = (long) cell.getNumericCellValue();
						log.info("run");
						break;

					}
					case 6: {

						itemDescription = cell.getStringCellValue();
						log.info("run");
						break;

					}

					default: {
						break;
					}

					}
					cellId++;

				}
				
				if (id != null && length != null && width != null && height != null && unit != null && rate != null && itemDescription != null) {

					// boqRequest.setItemDescription(itemDescription);
					boqRequest.setLength(length);
					boqRequest.setHeight(height);
					boqRequest.setWidth(width);
					boqRequest.setUnit(unit);
					boqRequest.setRate(rate);
					boqRequest.setId(id);
					boqRequest.setItemDescription(itemDescription);

					boqRequestList.add(boqRequest);
					
			      
			     
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		return boqRequestList;

	}

}
