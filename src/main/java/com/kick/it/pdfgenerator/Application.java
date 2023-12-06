package com.kick.it.pdfgenerator;

import com.kick.it.pdfgenerator.util.pdf.PDFGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.kick.it.pdfgenerator, com.kick.it.pdfgenerator.util.pdf"})
public class Application {

	public static void main(String[] args) {

		 SpringApplication.run(Application.class, args);
//		PDFGenerator pDFGenerator = ctx.getBean("pdfGenerator",PDFGenerator.class);
//
//		pDFGenerator.generatePdfReport();
	}

}
