package test;

import baseUrl.DummyRestapi_BaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyRestApiExpBodyPOJO;

import static io.restassured.RestAssured.given;

public class C27_Get_POJO_Veda_Classi extends DummyRestapi_BaseUrl {

    /*
    http://dummy.restapiexample.com/api/v1/employee/3 url’ine bir GET request
     gonderdigimizde donen response’un asagidaki gibi oldugunu test edin.

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
public void get01() {
    //1.Aşama:
    specDummyRestapi.pathParams("pp1","api","pp2","v1","pp3","employee","pp4",3);

    //2.Aşama:
    DummyRestApiExpBodyPOJO expBody=new DummyRestApiExpBodyPOJO()
    //3.Aşama:
    Response response=given().spec(specDummyRestapi).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");

    //4.Aşama:








}
}