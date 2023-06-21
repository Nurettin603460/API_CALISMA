package test;

import io.restassured.http.ContentType;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTest {


    @Test
    public void post01(){
            //1.aşama:
        String url= "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println(reqBody);

        // 2.Aşama: Expected Data:
        // 3.Aşama: Response kaydet

        Response response=given()
                                .contentType(ContentType.JSON)
                         .when()
                .body(reqBody.toString())
                .post(url);


    }  

}
