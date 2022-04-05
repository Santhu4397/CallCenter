package com.example.CallCenter.service;

import org.springframework.stereotype.Service;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

@Service
public class PDFReader {

	public void ReadPDFFile() throws Exception {
		try {

			PdfReader pdfReader = new PdfReader("C:/Users/TYSS/Downloads/CallCenter 2022-03-25_02_54_09.pdf");
			int pages = pdfReader.getNumberOfPages();
//			String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, 2);
			for (int i = 1; i <= pages; i++) {
				String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
				System.out.println("Content on Page " + i + ": " + pageContent);
				
			}
//System.out.println(pageContent+"==================");
			pdfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * // if the file is available in local machine File file = new
		 * File("D:\\callstatus.pdf"); FileInputStream fis = new FileInputStream(file);
		 * PDDocument pdfDocument = PDDocument.load(fis);
		 * 
		 * System.out.println("Number of Pages: " +pdfDocument.getPages().getCount());
		 * 
		 * PDFTextStripper pdfTextStripper = new PDFTextStripper();
		 * pdfTextStripper.setStartPage(1); // comment this line if you want to read the
		 * entire document pdfTextStripper.setEndPage(3); // comment this line if you
		 * want to read the entire document String docText =
		 * pdfTextStripper.getText(pdfDocument);
		 * 
		 * System.out.println(docText);
		 * 
		 * 
		 * 
		 * pdfDocument.close(); fis.close();
		 */
		// if the file is available in internet
		//		WebDriverManager.chromedriver().setup();
		//		WebDriver driver = new ChromeDriver();
		//		driver.manage().window().maximize();
		//		driver.get("https://file-examples.com/");
		//		driver.findElement(By.xpath("//h3[text()='Documents']/following-sibling::a")).click();
		//		driver.findElement(By.xpath("//td[text()='PDF']/following-sibling::td/a")).click();
		//		driver.findElement(By.xpath("//td[text()='150 kB']/following-sibling::td/a")).click();		
		//		String urlString = driver.getCurrentUrl();
		//		
		//		URL url = new URL("https://file-examples-com.github.io/uploads/2017/10/file-sample_150kB.pdf");
		//		PDDocument pdfDocument = PDDocument.load(url.openStream());
		//		
		//		System.out.println("Number of Pages: " +pdfDocument.getPages().getCount());
		//		
		//		PDFTextStripper pdfTextStripper = new PDFTextStripper();
		//		pdfTextStripper.setStartPage(1); // comment this line if you want to read the entire document
		//		pdfTextStripper.setEndPage(3); // comment this line if you want to read the entire document
		//		String docText = pdfTextStripper.getText(pdfDocument);
		//		
		//		System.out.println(docText);
		//
		//		Assert.assertTrue(docText.contains("Maecenas"));
		//		
		//		pdfDocument.close();
		//		driver.quit();
	}

}
