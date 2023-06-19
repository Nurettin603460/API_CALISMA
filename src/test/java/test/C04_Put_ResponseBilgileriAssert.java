package test;

import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C04_Put_ResponseBilgileriAssert {

    String url="https://jsonplaceholder.typicode.com/posts/70";
    Response response;

    @Test
    public void get01(){
        response= given().when().get(url);
        response.prettyPrint();
    }

    @Test
    public void put01(){

        JSONObject reqBodyJson= new JSONObject();

        reqBodyJson.put("title","Ahmet");
        reqBodyJson.put("body","Merhaba");
        reqBodyJson.put("userId","10");
        reqBodyJson.put("id","70");

        response=given()
                        .contentType(ContentType.JSON)
                .when()
                        .body(reqBodyJson.toString())
                .put(url);

        response.prettyPrint();

        response.then()
                    .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server", "cloudflare")
                .statusLine("HTTP/1.1 200 OK");


    }

}
