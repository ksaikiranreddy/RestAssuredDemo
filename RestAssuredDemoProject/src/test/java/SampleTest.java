import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SampleTest {

    String url="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/calendarByPin";

    @Test(enabled = false)
    public void vaccination()
    {
        given().queryParam("pincode","516309")
                .queryParam("date","04-05-2021")
                .when().get(url)
                .then().log().body();
    }

    @Test
    public void session()
    {
        Response session=given().queryParam("pincode","516309")
                .queryParam("date","04-05-2021")
                .contentType(ContentType.JSON)
                .when().get(url)
                .then().extract().response();

        if(session.jsonPath().get("centers[0].pincode").equals("516309"))
        {
            System.out.println("matched");
        }
        else
        {
            System.out.println(session.jsonPath().<Character>get("centers[0].pincode"));
        }

    }


}
