package CurdExample;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ParseJsonResponse {
    @Test

    //Below is a complete Test class source which demonstrates how to use REST Assured to
    // test a RESTful Web Service endpoint by sending
    // it HTTP Post request containing JSON payload with user login credentials
    // and then validates the Response object Headers to make sure that the required headers are present.
    public void parseJsonResopnse() {
        RestAssured.defaultParser = Parser.JSON;
        Response response =RestAssured.
                given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                        when().get("https://jsonplaceholder.typicode.com/users").
                        then().contentType(ContentType.JSON).extract().response();
        List<String> jsonResponse = response.jsonPath().getList("$");

        System.out.println(jsonResponse.size());

        //Parsing JSON Arrays and Lists
        String usernames = response.jsonPath().getString("username");
        System.out.println(usernames);

        //Parsing JSON ArrayList and HashMap
        List<Map<String, String>> companies = response.jsonPath().getList("company");
        System.out.println(companies.get(0).get("name"));

    }



}
