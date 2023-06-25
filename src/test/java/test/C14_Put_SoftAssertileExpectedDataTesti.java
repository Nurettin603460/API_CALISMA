package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;

public class C14_Put_SoftAssertileExpectedDataTesti {

    @Test
    public void put01(){

        //1.Aşama: Endpoint oluştur. ihtiyaç varsa (put, post, patch) requestBody oluştur

        String url="https://dummy.restapiexample.com/api/v1/update/21";


        JSONObject data=new JSONObject();
        data.put("name","Ahmet");
        data.put("salary",1230);
        data.put("age",44);
        data.put("id",40);

        JSONObject reqBody=new JSONObject();
        reqBody.put("status","success");
        reqBody.put("data",data);


        // 2.Aşama: Expected Data oluşturma: (expected Data= Response Body)

        JSONObject expData=new JSONObject();
        expData.put("status","succes");
        expData.put("data",reqBody);
        expData.put("message","Successfully! Record has been updated.");

        System.out.println("Expected Data :" +  expData);

        //3.Aşama: Response oluştur ve kaydet

       Response response=
                            given()
                                    .contentType(ContentType.JSON)
                            .when()
                                    .body(reqBody.toString())
                                    .put(url);
       response.prettyPrint();

       //4.Aşama: SoftAssert :
        SoftAssert softAssert=new SoftAssert(); // softassert objesi oluştur ve hemen softasser.assertAll ekle.
        JsonPath respJSonPath=response.jsonPath();

       softAssert.assertEquals(respJSonPath.get("data.status"), expData.getJSONObject("data").get("status"),"status hatalı");
       softAssert.assertEquals(respJSonPath.get("data.data.name"),expData.getJSONObject("data").getJSONObject("data").get("name"), "name hatalı");
       softAssert.assertEquals(respJSonPath.get("data.data.salary"), expData.getJSONObject("data").getJSONObject("data").get("salary"), "salary hatalı");
       softAssert.assertEquals(respJSonPath.get("data.data.age"), expData.getJSONObject("data").getJSONObject("data").get("age"), "age hatalı");
       softAssert.assertEquals(respJSonPath.get("data.data.id"), expData.getJSONObject("data").getJSONObject("data").get("id"), "id hatalı");
       softAssert.assertEquals(respJSonPath.get("message"), expData.get("message"), "message hatalı");

        softAssert.assertAll();
    }
}
