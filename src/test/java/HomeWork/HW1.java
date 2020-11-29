package HomeWork;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class HW1 {
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("hr_api_url");
    }

    @Test
    public void question1(){
        /* - Given accept type is Json
        - Path param value- US
        - When users sends request to /countries
        - Then status code is 200
        - And Content - Type is Json
        - And country_id is US
        - And Country_name is United States of America
        - And Region_id is 2

       */

        Response response=given().accept(ContentType.JSON)
                .and().pathParam("id","US")
                .when().get("/countries/{id}");

        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");
        Assert.assertEquals(response.path("country_id").toString(),"US");
        Assert.assertEquals(response.path("country_name").toString(),"United States of America");
        Assert.assertEquals(response.path("region_id").toString(),"2");

    }

    @Test
    public void question2(){
    /*  - Given accept type is Json
        - Query param value - q={"department_id":80}
        - When users sends request to /employees
        - Then status code is 200
        - And Content - Type is Json
        - And all job_ids start with 'SA'
        - And all department_ids are 80
        - Count is 25

     */

        Response response=given().accept(ContentType.JSON)
                .and().queryParam("q","{\"department_id\":80}")
                .when().get("/employees");


        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json");

        List<String> jobId=response.path("items.job_id");

        for (String s : jobId) {
            Assert.assertTrue(s.startsWith("SA"));
        }
        JsonPath jsonPath=response.jsonPath();


        List<String> departmentId=response.path("items.department_id");
        for ( String id : departmentId) {
            Assert.assertEquals(id,"80");

        }

        int count=response.path("count");
        Assert.assertEquals(count,25);
    }

    @Test
    public void test3(){

    /*   - Given accept type is Json
         -Query param value q= region_id 3
         - When users sends request to /countries
         - Then status code is 200
         - And all regions_id is 3
         - And count is 6
         - And hasMore is false
         - And Country_name are;
        Australia,China,India,Japan,Malaysia,Singapore
     */

        Response response=given().accept(ContentType.JSON)
                .and().queryParam("q","{\"region_id\":3}")
                .when().get("/countries");
        response.prettyPrint();
        JsonPath jsonPath=response.jsonPath();

        Assert.assertEquals(response.statusCode(),200);

        List<String> RegionId =jsonPath.getList("items.findAll {it.region_id==3}.region_id");

        Assert.assertEquals(jsonPath.getInt("count"),6);
        Assert.assertFalse(jsonPath.getBoolean("hasMore"));
        List<String> actualCountryName= Arrays.asList("Australia","China","India","Japan", "Malaysia", "Singapore");
        List<String> countryName=jsonPath.getList("items.country_name");
        Assert.assertEquals(countryName,actualCountryName);


    }

}
