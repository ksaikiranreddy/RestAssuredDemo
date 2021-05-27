import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class FindVaccination {

    public static void main(String[] args) {

        RestAssured.baseURI="https://cdn-api.co-vin.in";

        Response response=given().log().all().header("Connection","keep-alive")
                .when().get("/api/v2/appointment/sessions/public/calendarByPin?pincode=516309&date=04-05-2021")
                .then().assertThat().statusCode(200).extract().response();


    }
}
