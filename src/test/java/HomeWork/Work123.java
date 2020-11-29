package HomeWork;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Work123 {

    @BeforeClass
    public  void before(){
        baseURI= ConfigurationReader.get("hr_api_url");
    }

     @Test
    public void question(){
     /*    Q1:
         - Given accept type is Json
         - Path param value- US
         - When users sends request to /countries
         - Then status code is 200
         - And Content - Type is Json
         - And country_id is US
         - And Country_name is United States of America
         - And Region_id is

      */

         Response response=given().accept(ContentType.JSON)
                 .and().pathParam("id","US")
                 .when().get("/countries/{id}");
         Assert.assertEquals(response.statusCode(),200);
         Assert.assertEquals(response.contentType(),"Json");
         Assert.assertEquals(response.path("country_id").toString(),"US");
         Assert.assertEquals(response.path("country_name").toString(),"United States of America");
         Assert.assertEquals(response.path("region_id").toString(),"2");


     }

}
