package com.kick.it.pdfgenerator.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.kick.it.pdfgenerator.entities.Farmer;
import com.kick.it.pdfgenerator.repositories.FarmerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component("pdfGenerator")
public class PDFGenerator {

    @Value("${pdfDir}")
    private String pdfDir;

    @Value("${reportFileName}")
    private String reportFileName;

    @Value("${reportFileNameDateFormat}")
    private String reportFileNameDateFormat;

    @Value("${localDateFormat}")
    private String localDateFormat;

    @Value("${logoImgPath}")
    private String logoImagePath;

    @Value("${logoImgScale}")
    private float[] logoImageScale;

    @Value("${currencySymbol:}")
    private String currencySymbol;

    @Value("${table_noOfColumns}")
    private int noOfColumns;

    @Value("${table.columnNames}")
    private List<String> columnsName;

    @Value("${signImgPath}")
    private String singImagePath;

    @Value("${signImgScale}")
    private float[] signImageScale;

    @Autowired
    FarmerRepo farmerRepo;

    private static Font COURIER = new Font(Font.FontFamily.COURIER,20,Font.BOLD);
    private static Font COURIER_SMALL = new Font(Font.FontFamily.COURIER,16,Font.BOLD);
    private static Font COURIER_SMALL_FOOTER = new Font(Font.FontFamily.COURIER,12,Font.BOLD);


    public void generatePdfReport(){
        Document document = new Document();

        try {
            PdfWriter.getInstance(document,new FileOutputStream(getPdfNameWithDate()));
            document.open();
            addLogo(document);
            addDocTitle(document);
            createTable(document);
            addFooter(document);
            addSign(document);
            document.close();
            System.out.println("---------------Your Pdf report is ready-----------------");
        }catch (FileNotFoundException | DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void addLogo(Document document){
        try{
            Image img = Image.getInstance(logoImagePath);
            img.scalePercent(logoImageScale[0],logoImageScale[1]);
            img.setAlignment(Element.ALIGN_RIGHT);
            document.add(img);
        } catch (DocumentException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private void addDocTitle(Document document) throws DocumentException{
        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(localDateFormat));
        Paragraph para = new Paragraph();
        leaveEmptyLine(para, 1);
        para.add(new Paragraph(reportFileName,COURIER));
        para.setAlignment(Element.ALIGN_CENTER);
        leaveEmptyLine(para, 1);
        para.add(new Paragraph("Report generated at "+localDateString,COURIER_SMALL));
        document.add(para);

    }

    private void createTable(Document document) throws DocumentException{
        Paragraph para = new Paragraph();
        leaveEmptyLine(para,1);
        document.add(para);

        PdfPTable table = new PdfPTable(noOfColumns);

        for(int i=0;i<noOfColumns;i++){
            PdfPCell cell = new PdfPCell(new Phrase(columnsName.get(i)));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.CYAN);
            table.addCell(cell);
        }

        table.setHeaderRows(1);
        getDbData(table);

        document.add(table);
    }

    private void getDbData(PdfPTable table) {

        List<Farmer> list = farmerRepo.findAll();
        for (Farmer farmer : list) {

            table.setWidthPercentage(100);
            table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
            table.getDefaultCell().setVerticalAlignment(Element.ALIGN_MIDDLE);

            table.addCell(String.valueOf(farmer.getId()));
            table.addCell(farmer.getName());
            table.addCell(String.valueOf(farmer.getLandInHactre()));
            if(farmer.isLoan()){
                table.addCell("True");
            }
            else{
                table.addCell("False");
            }


            System.out.println(farmer.getName());
        }

    }


    private void addFooter(Document document) throws  DocumentException{
        Paragraph para = new Paragraph();
        leaveEmptyLine(para, 3);
        para.setAlignment(Element.ALIGN_MIDDLE);
        para.add(new Paragraph(
                "------------------------End Of " +reportFileName+"------------------------",
                COURIER_SMALL_FOOTER));

        document.add(para);
    }

    private void addSign(Document document) {
        try {
            leaveEmptyLine(new Paragraph(), 2);
            Image sign = Image.getInstance(singImagePath);
            sign.scalePercent(signImageScale[0], signImageScale[1]);
            sign.setAlignment(Element.ALIGN_RIGHT);
            document.add(sign);
        }catch (DocumentException | IOException e){
            e.printStackTrace();
        }

    }

    private static void leaveEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    private String getPdfNameWithDate() {
        String localDateString = LocalDateTime.now().format(DateTimeFormatter.ofPattern(reportFileNameDateFormat));
        return pdfDir+reportFileName+"-"+localDateString+".pdf";
    }
}
