package apitests.Day8;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class SpartanFlow {
    int idSpartan;
    @BeforeClass
    public void beforeclass(){
        baseURI= ConfigurationReader.get("spartan_api_url");
    }

  @Test(priority = 1)
   public  void  PostNewSpartan(){

     Map<String,Object> newSpartan=new HashMap<>();
     newSpartan.put("name","Kazım");
     newSpartan.put("gender","Male");
     newSpartan.put("phone",6548526973l);


      Response response = given().log().all().accept(ContentType.JSON)
              .and().contentType(ContentType.JSON)
              .and().body(newSpartan)
              .when().post("/api/spartans");

      assertEquals(response.statusCode(),201);
      assertEquals(response.contentType(),"application/json");
      assertEquals(response.path("data.name"),"Kazım");
      assertEquals(response.path("data.gender"),"Male");
      assertEquals(response.path("success"),"A Spartan is Born!");

//             .then().log().all().statusCode(201)
//             .and().contentType("application/json")
//     .and().body("success",is("A Spartan is Born!"),
//             "data.name",equalTo("Kazım"),
//             "data.gender",equalTo("Male"),
//             "dat.phone",equalTo(6548526973l));


      idSpartan=response.path("data.id");
      System.out.println("id = " + idSpartan);


  }


    @Test(priority = 2)
    public  void  PutExistingSpartan(){
        Map<String,Object> putSpartan=new HashMap<>();
        putSpartan.put("name","TomAndJerry");
        putSpartan.put("gender","Male");
        putSpartan.put("phone",6548526973l);

        given().log().all().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .and().pathParam("id",idSpartan)
                .and().body(putSpartan)
                .when().put("/api/spartans/{id}")
                .then().log().all()
                .and().statusCode(204);




    }

    @Test(priority = 3)
    public  void  PatchExistingSpartan(){

        Map<String,Object> patchSpartan=new HashMap<>();
        patchSpartan.put("name","Geveze");


        given().log().all()
                .and()
                .contentType(ContentType.JSON)
                .and()
                .pathParam("id",idSpartan)
                .and()
                .body(patchSpartan).
                when()
                .patch("/api/spartans/{id}")
                .then().log().all()
                .assertThat().statusCode(204);


    }

    @Test(priority = 4)
    public  void  GetThatSpartan(){

        System.out.println("idSpartan = " + idSpartan);

        given().accept(ContentType.JSON)
              .contentType(ContentType.JSON)
              .pathParam("id",idSpartan)
              .when().get("api/spartans/{id}")
      .then().statusCode(200).log().all();

    }

    @Test(priority = 5)
    public void DELETEThatSpartan(){

         given().pathParam("id",idSpartan)
                 .when().delete("/api/spartans/{id}")
                 .then().assertThat().statusCode(204).log().all();

    }
}
