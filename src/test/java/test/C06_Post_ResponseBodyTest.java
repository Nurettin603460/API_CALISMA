package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Post_ResponseBodyTest {


    @Test
    public void post01(){
            //1.aşama: EndPoint oluşturma. ihtiyaç varsa RequestBody oluştur(3p)
        String url= "https://jsonplaceholder.typicode.com/posts";

        JSONObject reqBody = new JSONObject();
        reqBody.put("title","API");
        reqBody.put("body","API ogrenmek ne guzel");
        reqBody.put("userId",10);

        System.out.println(reqBody);

        // 2.Aşama: Expected Data: (expected data= response body)
        // 3.Aşama: Response oluştur ve kaydet

        Response response=given()
                                .contentType(ContentType.JSON)
                         .when()
                .body(reqBody.toString())
                .post(url);
        response.prettyPrint();

        //4.Aşama: Assertion

        response.then()
                    .assertThat()
                        .statusCode(201)
                        .contentType("application/json")
                        .body("title",Matchers.equalTo("API"))
                        .body("userId", Matchers.lessThan(100))
                        .body("body",Matchers.containsString("API"));


    }  

}
