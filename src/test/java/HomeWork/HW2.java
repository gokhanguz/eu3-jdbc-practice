package HomeWork;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class HW2 {

    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }

    @Test
    public void question1(){

        Response response=given().accept(ContentType.JSON)
                .and().pathParam("id",20)
                .when().get("/api/spartans/{id}");
        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");
        Assert.assertTrue(response.headers().hasHeaderWithName("Date"));
        Assert.assertEquals(response.getHeader("Transfer-Encoding"),"chunked");
        Assert.assertEquals(response.path("id").toString(),"20");
        Assert.assertEquals(response.path("name").toString(),"Lothario");
        Assert.assertEquals(response.path("gender").toString(),"Male");
        Assert.assertEquals(response.path("phone").toString(),"7551551687");

    }
    @Test
    public void question2(){

        Response response=given().accept(ContentType.JSON)
                .and().queryParam("gender","Female")
                .and().queryParam("nameContains","r")
                .when().get("/api/spartans/search");
        response.prettyPrint();


        Assert.assertEquals(response.statusCode(),200);
        Assert.assertEquals(response.contentType(),"application/json;charset=UTF-8");

        List<String> genders=response.path("content.gender");

        for (String gender : genders) {
            Assert.assertEquals(gender,"Female");
        }

        List<String > names=response.path("content.name");
        for (String name : names) {
            Assert.assertTrue(name.toLowerCase().contains("r"));
        }

        int size=response.path("size");
        Assert.assertEquals(size,20);

        int totalPages=response.path("totalPages");
        Assert.assertEquals(totalPages,1);

        boolean sort=response.path("sort.sorted");
        Assert.assertFalse(sort);

        //second way
        JsonPath jsonPath=response.jsonPath();
        List<String > genderJson=jsonPath.getList("items.findAll{it.gender==\"Female\"}.gender");
        Assert.assertEquals(jsonPath.getInt("size"),20);
        Assert.assertEquals(jsonPath.getInt("totalPages"),1);
        Assert.assertFalse(jsonPath.getBoolean("sort.sorted"));
    }
}
