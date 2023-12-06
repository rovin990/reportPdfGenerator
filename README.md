# reportPdfGenerator

##Steps to create project
    ### Create springboot project with bellow dependecy
        <dependency>
  			<groupId>com.itextpdf</groupId>
  			<artifactId>itextpdf</artifactId>
  			<version>5.5.13.3</version>
  		</dependency>

      <dependency>
  			<groupId>org.springframework.boot</groupId>
  			<artifactId>spring-boot-starter-data-jpa</artifactId>
  		</dependency>

      <dependency>
  			<groupId>com.mysql</groupId>
  			<artifactId>mysql-connector-j</artifactId>
  			<scope>runtime</scope>
  		</dependency>
    ### Create entitie and repositories as per requirement
          Here i am using one entity(Farmer) and one Repository(FarmerRepo)
    ### Create PDFGenerator.java file
          Here write all logic for generating pdf such as add title , add logo , load data from db to build table , add footer also add signature
          Add other thing as per you need

## Tools are used in this project
  Java-17
  springboot 3.2.0
  itextpdf 5.5.13.3

## Rest follow code files




  
