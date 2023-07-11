package test;

import baseUrl.DummyRestapi_BaseUrl;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.DummyRestApiDataPOJO;
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
    DummyRestApiDataPOJO dataBody=new DummyRestApiDataPOJO(3,"Ashton Cox",86000,66,"");
    DummyRestApiExpBodyPOJO expBody=new DummyRestApiExpBodyPOJO("success", dataBody,"Successfully! Record has been fetched.");
    System.out.println("ExpBody= "+ expBody);

    //3.Aşama:
    Response response=given().spec(specDummyRestapi).when().get("/{pp1}/{pp2}/{pp3}/{pp4}");
    response.prettyPrint();

    //4.Aşama:

    DummyRestApiExpBodyPOJO respPOJO=response.as(DummyRestApiExpBodyPOJO.class);
    Assert.assertEquals(expBody.getStatus(),respPOJO.getStatus() );
    Assert.assertEquals(expBody.getData().getId(),respPOJO.getData().getId());
    Assert.assertEquals(expBody.getData().getEmployee_name(),respPOJO.getData().getEmployee_name());
    Assert.assertEquals(expBody.getData().getEmployee_salary(),respPOJO.getData().getEmployee_salary());
    Assert.assertEquals(expBody.getData().getEmployee_age(),respPOJO.getData().getEmployee_age());
    Assert.assertEquals(expBody.getData().getProfile_image(),respPOJO.getData().getProfile_image());
    Assert.assertEquals(expBody.getMessage(), respPOJO.getMessage());








}
}