import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.sameInstance;

public class BaseProgram {

    public static void main(String[] args) {

        RestAssured.baseURI="https://buildyourbet.beta.coral.co.uk";

       Response response=given().log().all().header("Connection","keep-alive")
                .when().get("/api/v1/events/16929167")
                .then().assertThat().statusCode(200).extract().response();

       if (response.path("data.obTypeId").equals(971))
       {
           System.out.println("type id matched");
       }
    }
}
