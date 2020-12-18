package HomeWork;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import utilities.ExcelUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class HwAddSpartanWithExceell {

    int idSpartan;
    Response response;

    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }


    @Test
    public void test(){

        ExcelUtil spartan= new ExcelUtil("src/test/resources/Spartans.xlsx","data");


        List<Map<String, Object>> data = spartan.getDataList();

      for (Map<String, Object> eachSpartan : data) {

            Response response = given().log().all().accept(ContentType.JSON)
                    .and().contentType(ContentType.JSON)
                    .and().body(eachSpartan)
                    .when().post("/api/spartans");
            assertEquals(response.statusCode(),201);

            idSpartan=response.path("data.id");





            given().accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .pathParam("id",idSpartan)
                    .when().get("api/spartans/{id}")
                    .then().statusCode(200).log().all();
        }



       // BigDecimal phone = new BigDecimal(String.valueOf(data.get("phone")));


    }

    @Test
    public  void test2() throws IOException {

        FileInputStream file=new FileInputStream("C:\\Users\\Gökhan\\IdeaProjects\\eu3-jdbc-practice\\src\\test\\resources\\Spartans.xlsx");

        Workbook workbook= WorkbookFactory.create(file);

        Sheet sheet=workbook.getSheet("data");

        int rowCount=sheet.getLastRowNum()+1;
        System.out.println("rowCount = " + rowCount);

        BigDecimal asd= new BigDecimal(String.valueOf(sheet.getRow(1).getCell(2)));
        System.out.println("asd = " + asd);



          for (int i=1;i<rowCount;i++){
              Map<String, Object> spartan=new HashMap<>();
              BigDecimal phone=new BigDecimal(String.valueOf(sheet.getRow(i).getCell(2)));
              Cell cell=sheet.getRow(i).getCell(0);
              String name1=cell.toString();
              spartan.put("name",name1);


              Cell cell1=sheet.getRow(i).getCell(1);
              String gender=cell1.toString();
              spartan.put("gender",gender);

              spartan.put("phone",new BigDecimal(String.valueOf(sheet.getRow(i).getCell(2))));


              Response response=given().log().all().accept(ContentType.JSON)
                      .and().contentType(ContentType.JSON)
                      .and().body(spartan)
                      .when().post("/api/spartans");

              assertEquals(response.statusCode(),201);

              idSpartan=response.path("data.id");





              given().accept(ContentType.JSON)
                      .contentType(ContentType.JSON)
                      .pathParam("id",idSpartan)
                      .when().get("api/spartans/{id}")
                      .then().statusCode(200).log().all();

          }


    }

}
