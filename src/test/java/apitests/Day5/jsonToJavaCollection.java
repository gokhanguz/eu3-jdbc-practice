package apitests.Day5;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.math.BigDecimal;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class jsonToJavaCollection {

    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }

    @Test
    public void SpartanToMap(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(),200);

        //we will convert json response to java map
        Map<String,Object> jsonDataMap = response.body().as(Map.class);

        System.out.println("jsonDataMap = " + jsonDataMap);

        String name= (String) jsonDataMap.get("name");
        assertEquals(name,"Nona");

        Double phone= (Double) jsonDataMap.get("phone");
        System.out.println("phone = " + phone);

        BigDecimal phone1 = new BigDecimal(String.valueOf(jsonDataMap.get("phone")));
        System.out.println("phone1 = " + phone1);
    }
}