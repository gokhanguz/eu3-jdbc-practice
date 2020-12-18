package HomeWork;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class HwAddSpartanMackaroo {
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }

    //Homework-2
    //-Create one mackaroo api for name,gender,phone
    //send get request to retrieve random info from that api
    //use those info to send post request to spartan

    String apiurl="https://my.api.mockaroo.com/spartan.json?key=c418a970";

    @Test
    public void test1(){

        Response response=given().accept(ContentType.JSON)
                .when().get(apiurl);

        List<Map<String,Object>> allSpartan = response.body().as(List.class);

        for(int i=0;i<allSpartan.size();i++){
            Map<String,Object> spartan=new HashMap<>();

            spartan.put("name",allSpartan.get(i).get("n"));
            spartan.put("gender",allSpartan.get(i).get("g"));
            spartan.put("phone",allSpartan.get(i).get("i"));
            System.out.println("spartan.toString() = " + spartan.toString());

            Response response1 = given().log().all().accept(ContentType.JSON)
                    .and().contentType(ContentType.JSON)
                    .and().body(spartan)
                    .when().post("/api/spartans");
            response1.prettyPrint();


            int id=response1.path("data.id");

            given().log().all().accept(ContentType.JSON)
                    .and().pathParam("id",id)
                    .when().get("api/spartans/{id}")
                    .then().statusCode(200).log().all();

        }



       /* for (Map<String, Object> stringObjectMap : allSpartan) {
            System.out.println(stringObjectMap);

            Response response1=given().accept(ContentType.JSON)
                    .and().body(stringObjectMap)
                    .when()
                    .post("/api/spartans");
            response1.prettyPrint();

            int id=response1.path("data.id");

            given().log().all().accept(ContentType.JSON)
                    .and().pathParam("id",id)
                    .when().get("api/spartans/{id}")
                    .then().statusCode(200).log().all();

        }

        */

    }


}
