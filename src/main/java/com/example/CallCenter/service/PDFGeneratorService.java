package com.example.CallCenter.service;


import com.example.CallCenter.Dto.CallCenterDto;
import com.example.CallCenter.Repo.CallCenterRepo;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;

import java.awt.Color;
import java.io.IOException;

@Service
public class PDFGeneratorService {
	@Autowired 
	CallCenterRepo repo;
    public void export(HttpServletResponse response,int id) throws IOException {
    	CallCenterDto dto=repo.getById(id);
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);
        fontTitle.setColor(Color.BLUE);
        Paragraph paragraph = new Paragraph("Call Detials of "+dto.getName(), fontTitle);
        paragraph.setAlignment(Paragraph.ALIGN_CENTER);

        Font fontParagraph = FontFactory.getFont(FontFactory.HELVETICA);
        fontParagraph.setSize(12);
        fontParagraph.setColor(Color.RED);

        Paragraph paragraph2 = new Paragraph("Id :"+dto.getId(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        Paragraph paragraph3 = new Paragraph("Name :"+dto.getName(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        Paragraph paragraph4 = new Paragraph("CallStatus :"+dto.getCallStatus().name(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        Paragraph paragraph5= new Paragraph("Phonenumber :"+dto.getPhonenumber(), fontParagraph);
        paragraph2.setAlignment(Paragraph.ALIGN_LEFT);
        document.add(paragraph);
        document.add(paragraph2);
        document.add(paragraph3);
        document.add(paragraph4);
        document.add(paragraph5);
     
        document.close();
    }
}
