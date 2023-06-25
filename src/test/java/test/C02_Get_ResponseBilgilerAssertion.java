package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class C02_Get_ResponseBilgilerAssertion {

    @Test
    public void get02(){
        String url="https://restful-booker.herokuapp.com/booking/10";
        Response response = given().when().get();

        response.prettyPrint();
        response
                .then()
                    .assertThat()
                    .statusCode(200)
                    .contentType("application/json; charset=utf-8")
                    .header("Server","Cowboy")
                    .statusLine("HTTP/1.1 200 OK");




    }


}
