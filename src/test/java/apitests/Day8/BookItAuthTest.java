package apitests.Day8;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class BookItAuthTest {

    @BeforeClass
    public void before(){

        baseURI ="https://cybertek-reservation-api-qa2.herokuapp.com";
    }
   String accessToken="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxNDIiLCJhdWQiOiJzdHVkZW50LXRlYW0tbWVtYmVyIn0.cxmEHKFeK49E1ilZ5gU_G0HmUKoYfvy2Cc65OIfFQ24";
    @Test
    public void getALLCAmpuses(){


        Response response = given().header("Authorization", accessToken)
                .when().get("/api/campuses");

        response.prettyPrint();
        System.out.println(response.statusCode());
    }

}
