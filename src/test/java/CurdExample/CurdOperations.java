package CurdExample;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.FileNotFoundException;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class CurdOperations {

   @Test
    public void TC01_GET() {
        RestAssured.baseURI = "http://localhost:3000/";
        Response response = RestAssured
                .given().
                        contentType(ContentType.JSON).
                        accept(ContentType.JSON).
                        when().
                        get("users");
        System.out.println("Response is : " + response.getBody().asString());
        System.out.println("Response is : " + response.getHeader("content-type"));
        int statusCode = response.getStatusCode();
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.contentType());
        System.out.println(response.getTime());
        String usernames = response.jsonPath().getString("firstName[0]");
        System.out.println("user name is : " + usernames);
        Assert.assertEquals(statusCode, 200);
    }

   @Test
    public void TC02_GET() throws FileNotFoundException {
        given()
                .param("key", "value")
                .header("key", "value")
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data[0].id", equalTo(7))
                .body("data.first_name", hasItems("Michael", "Lindsay"))
                .log().all().assertThat().statusCode(200);

    }

   @Test

//   Make HTTP Post request with REST Assured,
//Create JSON Object using the com.google.gson library or other library,
//Send JSON payload in the body of HTTP Post request,
//Validate the Response

    public void TC03_Post() throws FileNotFoundException {
        RestAssured.baseURI = "http://localhost:3000/";
        JSONObject jsonObjectRequest = new JSONObject();
        System.out.println(jsonObjectRequest);
        jsonObjectRequest.put("firstName","ram");
        jsonObjectRequest.put("lastName", "saini");
        jsonObjectRequest.put("subjectId", 5);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(jsonObjectRequest.toJSONString()).
                when().
                post("users").
                then().statusCode(201).log().all();
//       Assert.assertEquals(201, response.statusCode());
//       Assertions.assertEquals("qui est esse", response.jsonPath().getString("title[1]"));

    }
    @Test
    public void getRequestWithQueryParam() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        Response response = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("/comments")
                .then()
                .extract().response();

        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals("Meghan_Littel@rene.us", response.jsonPath().getString("email[3]"));
    }

    @Test
    public void TC04_Put() throws FileNotFoundException {
        RestAssured.baseURI = "http://localhost:3000/";
        JSONObject jsonObjectRequest = new JSONObject();
        System.out.println(jsonObjectRequest);
        jsonObjectRequest.put("firstName","r s gour");
        jsonObjectRequest.put("lastName", "kumar");
        jsonObjectRequest.put("subjectId", 30);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(jsonObjectRequest.toJSONString()).
                when().
                put("users/1").
                then().statusCode(200).log().all();

    }

   @Test
    public void TC05_Patch() {
        RestAssured.baseURI = "http://localhost:3000/";
        JSONObject jsonObjectRequest = new JSONObject();
        System.out.println(jsonObjectRequest);
       jsonObjectRequest.put("firstName","mahesh");
       jsonObjectRequest.put("lastName", "babu");
        jsonObjectRequest.put("subjectId", 10);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type","application/json").
                body(jsonObjectRequest.toJSONString()).
                when().
                put("users/2").
                then().statusCode(200).log().all();

    }
   //@Test
    public void TC06_Delete() {
        RestAssured.baseURI = "http://localhost:3000/";
        given().
                when().
                delete("users/3").
                then().log().all();

    }
}

