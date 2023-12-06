package com.kick.it.pdfgenerator.entities;

import com.kick.it.pdfgenerator.repositories.FarmerRepo;
import com.kick.it.pdfgenerator.util.pdf.PDFGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FarmerTest {

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    FarmerRepo farmerRepo;

    @Test
    public void saveAllMethod(){
//        Farmer f1 = new Farmer();
//        f1.setLoan(true);
//        f1.setName("Krishana");
//        f1.setLandInHactre(2.5);
//        Farmer f2 = new Farmer();
//        f2.setLoan(true);
//        f2.setName("Krishana");
//        f2.setLandInHactre(2.5);
//        Farmer f3 = new Farmer();
//        f3.setLoan(true);
//        f3.setName("Krishana");
//        f3.setLandInHactre(2.5);
//        Farmer f4 = new Farmer();
//        f4.setLoan(true);
//        f4.setName("Krishana");
//        f4.setLandInHactre(2.5);
//        Farmer f5 = new Farmer();
//        f5.setLoan(true);
//        f5.setName("Krishana");
//        f5.setLandInHactre(2.5);
//
//        farmerRepo.saveAll(List.of(f1,f2,f3,f4,f5));

        pdfGenerator.generatePdfReport();


    }
}