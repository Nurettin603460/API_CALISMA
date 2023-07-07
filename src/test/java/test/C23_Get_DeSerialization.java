package test;

import baseUrl.DummyRestapi_BaseUrl;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataDummyRestApi;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;

public class C23_Get_DeSerialization extends DummyRestapi_BaseUrl {
  /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET
    request gonderdigimizde donen response’un status code’unun 200,
    content Type’inin application/json ve body’sinin asagidaki gibi
    oldugunu test edin.

    Response Body
    {
    "status":"success",
    "data":{
            "id":3,
            "employee_name":"Ashton Cox",
            "employee_salary":86000,
            "employee_age":66,
            "profile_image":""
            },
    "message":"Successfully! Record has been fetched."
    }
     */

    @Test
    public void get01(){

        //1.Aşama:
            specDummyRestapi.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

       //2.Aşama:
        TestDataDummyRestApi testDataDummyRestApi=new TestDataDummyRestApi();
        HashMap<String, Object> expBody=testDataDummyRestApi.expectedBodyMapOlustur();

        //3.Aşama:
       Response response= given().spec(specDummyRestapi).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
       response.prettyPrint();

       //4.Aşama:
       Assert.assertEquals(testDataDummyRestApi.statusCode,response.getStatusCode());
        Assert.assertEquals(testDataDummyRestApi.contentType, response.getContentType());

        HashMap<String, Object> respMap=response.as(HashMap.class);

        Assert.assertEquals(expBody.get("status"),respMap.get("status"));
        Assert.assertEquals(expBody.get("message"),respMap.get("message"));

        Assert.assertEquals(  ((Map)(expBody.get("data"))).get("id"),((Map)(respMap.get("data"))).get("id") );

    }


}
