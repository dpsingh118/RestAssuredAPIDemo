package CurdExample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class SubmitForm {
    // @Test
    public void submitForm() {
        RestAssured.baseURI = "https://reqres.in/api";
        given().urlEncodingEnabled(true)
                .param("email", "michael.lawson@reqres.in")
                .param("first_name", "Michael")
                .header("Accept", ContentType.JSON.getAcceptHeader())
                .post("/users?page=2")
                .then().log().all();
    }

    @Test
    public void RegistrationSuccessful() {
       // RestAssured.baseURI ="http://localhost:3000/";
        RequestSpecification requestSpecification = given().baseUri("http://localhost:3000/").basePath("users");
        requestSpecification.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        System.out.println(requestParams);
        requestParams.put("firstName", "rat");
        requestParams.put("lastName", "singh");
        requestParams.put("subjectId", 500);

        requestSpecification.body(requestParams.toJSONString());
        Response response = requestSpecification.post();
        //Response response = requestSpecification.post("users");
        String fName = response.jsonPath().getString("firstName");
        System.out.println("first name is : " + fName);
        int statusCode = response.getStatusCode();
        System.out.println("statusCode is : "+ statusCode);
        Assert.assertEquals(statusCode, 201);
//        String successCode = response.jsonPath().get("SuccessCode");
//        Assert.assertEquals("Correct Success code was returned", statusCode, "OPERATION_SUCCESS");
    }

    //*********** how to send a request with Query Parameters in Rest Assured? **********
    @Test
    public void queryParameter() {

        //The full-service URL with the endpoint is:
        // https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=2b1fd2d7f77ccf1b7de9b441571b39b8

        // Specify the base URL to the RESTful web service
        RestAssured.baseURI ="https://samples.openweathermap.org/data/2.5/";
        RequestSpecification request = RestAssured.given();
        //send the resource details of the city, country, and the id to search the weather for in the GET request.
        Response response = request.queryParam("q", "London,UK")
                .queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
                .get("/weather");
        //After that, validate the GET Request response.
        String jsonString = response.asString();
        System.out.println(response.getStatusCode());
        Assert.assertEquals(jsonString.contains("London"), true);
    }

    //Hamcrest assertion:
    @Test
    void test() {
        RestAssured.given().when()
                .get("https://chercher.tech/sample/api/product/read?id=3793")
                .then()
                .body("id[0]", equalTo("3793"));
    }
}
