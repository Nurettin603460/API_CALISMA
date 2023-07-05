package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;

public class C19_Put_TestDataClassKullanımı extends JsonPlaceHolderBaseUrl {

    @Test
    public void put01(){
        //1.Aşama:
        specJsonPlace.pathParams("pp1", "posts","pp2",70);

       TestDataJsonPlace testDataJsonPlace =new TestDataJsonPlace();
       JSONObject reqJsonObj=testDataJsonPlace.requestJsonBodyOlustur();

       //2.Aşama:
        JSONObject expJsonObj=testDataJsonPlace.expectedJsonBodyOlustur();

        //3.Aşama:
        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        //4.Aşama:
        SoftAssert softAssert=new SoftAssert();
        JsonPath respJsonPath=response.jsonPath();

        softAssert.assertEquals(respJsonPath.get("title"),expJsonObj.get("title"));


        softAssert.assertAll();
    }
}
