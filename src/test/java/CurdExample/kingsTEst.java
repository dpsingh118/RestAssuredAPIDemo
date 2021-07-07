package CurdExample;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class kingsTEst {


    @DataProvider(name = "DataForPost")
    public Object[][] dataForPost() {

//			Object[][] data = new Object[2][3];//
//			data[0][0] = "Thomas";
//			data[0][1] = "Edison";
//			data[0][2] = 1;//
//			data[1][0] = "Albert";
//			data[1][1] = "Einstein";
//			data[1][2] = 2;//
//			return data;

        return new Object[][]{
                {"Albert", "Einstein", 2},
                {"Thomas", "Edison", 1},
                {"Henry", "Ford", 2}
        };
    }

    @Test(dataProvider = "DataForPost")
    public void test_post(String firstName, String lastName, int subjectId) {
        baseURI = "http://localhost:3000";
        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectId", subjectId);
        request.put("subjectId", subjectId);
        request.put("subjectId", subjectId);
        request.put("subjectId", subjectId);
        request.put("subjectId", subjectId);
        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201)
                .log().all();
    }
}
