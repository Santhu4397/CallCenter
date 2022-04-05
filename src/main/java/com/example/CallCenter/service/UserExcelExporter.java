package com.example.CallCenter.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.example.CallCenter.Dto.CallCenterDto;



public class UserExcelExporter {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	

	private List<CallCenterDto>  list;
	
	public UserExcelExporter(List<CallCenterDto> list) {
		this.list=list;
		workbook = new XSSFWorkbook();
		
	}
	
	private void createCell(Row row,int columnCount, Object value,CellStyle style) {
		sheet.autoSizeColumn(columnCount);
		Cell cell=row.createCell(columnCount);
		if(value instanceof Long) {
			cell.setCellValue((Long) value);
		}else if(value instanceof Integer) {
			cell.setCellValue((Integer) value);
		}else if(value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		}else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);
	}
	private void writeHeaderLine() {
		sheet=workbook.createSheet("CallCenter");
		
		Row row = sheet.createRow(0);
		CellStyle style = workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setBold(true);
		font.setFontHeight(20);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		createCell(row,0,"CallCenter Information",style);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,4));
		font.setFontHeightInPoints((short)(10));
		
		row=sheet.createRow(1);
		font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Id", style);
        createCell(row, 1, "call status", style);
        createCell(row, 2, "name", style);
        createCell(row, 3, "phonenumber", style);
        
	}
	
	private void writeDataLines() {
		int rowCount=2;
		
		CellStyle style=workbook.createCellStyle();
		XSSFFont font=workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		
		for(CallCenterDto dto:list) {
			Row row=sheet.createRow(rowCount++);
			System.out.println( dto.getCallStatus());
			int columnCount=0;
			createCell(row, columnCount++, dto.getId(), style);
			createCell(row, columnCount++, dto.getCallStatus().name(), style);
			createCell(row, columnCount++, dto.getName(), style);
			createCell(row, columnCount++, dto.getPhonenumber(), style);
		}
	}
	
	public void export(HttpServletResponse response) throws IOException{
		writeHeaderLine();
		writeDataLines();
		
		ServletOutputStream outputStream=response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
	
	
}
