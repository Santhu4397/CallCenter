package com.example.CallCenter.Controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CallCenter.Dto.CallCenterDto;
import com.example.CallCenter.Repo.CallCenterRepo;
import com.example.CallCenter.service.PDFGeneratorService;
import com.example.CallCenter.service.PDFReader;
import com.example.CallCenter.service.UserExcelExporter;



@RestController
public class HomeController {
	
	@Autowired
	private PDFReader reader;
	@Autowired
	private CallCenterRepo center;

	@Autowired 
	private PDFGeneratorService pdfGeneratorService;

	@GetMapping("/excel/generate")//converting  database data to excel sheet and download excel sheet
	public void exportToExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		String headerKey = "Content-Disposition";
		String headervalue = "attachment; filename=callstatus.xlsx";

		response.setHeader(headerKey, headervalue);
		List<CallCenterDto> list = center.findAll();
		UserExcelExporter exp = new UserExcelExporter(list);
		exp.export(response);

	}

	@GetMapping("/pdf/generate")//converting database data to pdf and download pdf in order to do that pass the id for the data you want as RequestParam 
	public void generatePDF(HttpServletResponse response, @RequestParam int id) throws IOException {
		System.out.println(id);
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());

		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=CallCenter " + currentDateTime + ".pdf";
		response.setHeader(headerKey, headerValue);

		pdfGeneratorService.export(response, id);
	}
	@GetMapping("/readpdf")// read from pdf
	public void reader() throws Exception {
		reader.ReadPDFFile();
	}
}
