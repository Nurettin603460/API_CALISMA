package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma {
    @Test
    public void get(){
        //1.Aşama: Endpoint hazırla. ihtiyaç varsa request body hazırla(3p)
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2.Aşama: Expected Data Hazırla:
        JSONObject expData=new JSONObject();
        expData.put("userID",3);
        expData.put("Id",22);
        expData.put("title","dolar sint qua a velit explicabo quia nam");
        expData.put("body","aaaaaaaaa");

        System.out.println("Expected Data: " + expData);

        // 3.aşama: Response oluştur ve kaydet:
        Response response=given()
                                .contentType(ContentType.JSON)
                                .when()
                                .get(url);
            response.prettyPeek(); // Response ile ilgili tüm detaylı bilgileri döndürür

        //4.aşama: Assertion:


    }

}
