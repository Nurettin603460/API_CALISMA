package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlace;

import java.util.HashMap;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {

    /*
   https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki body’e sahip bir
PUT request yolladigimizda donen response’in response body’sinin asagida verilen ile ayni oldugunu test ediniz
    */

    @Test
    public void put01(){
        //1.Aşama:
        specJsonPlace.pathParams("pp1","posts","pp2",70);
        TestDataJsonPlace testDataJsonPlace=new TestDataJsonPlace();
        HashMap<String, Objects> reqBody= testDataJsonPlace.requestBodyOlusturMap();

        //2.Aşama:
        HashMap<String, Object> expBody=testDataJsonPlace.requestBodyOlusturMap();

        //3.Aşama:
       Response response=given()
               .spec(specJsonPlace)
               .contentType(ContentType.JSON)
               .when()
               .body(reqBody)
               .put("/{pp1}/{pp2}");
       response.prettyPrint();

       //4.Aşama: Not:Response objesi map.e dönüştürüldü. Dönüşüm için pomxml.e ekleme yapıldı: Gson
       HashMap<String, Objects> respMap=  response.as(HashMap.class);
        Assert.assertEquals(expBody.get("title"), respMap.get("title"));

    }
}
