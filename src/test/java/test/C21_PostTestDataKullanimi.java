package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataHerokuApp;

import static io.restassured.RestAssured.given;


public class C21_PostTestDataKullanimi extends Herokuapp_BaseUrl {
    /*
    https://restfulbooker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde donen response’un status kodunu ve id haric asagidaki gibi oldugunu test edin.

Request Body
{
"firstname" : "Ahmet"
"lastname" : “Bulut"
"totalprice" : 500
"depositpaid" : false
"bookingdates" : {
    "checkin" : "2021-06-01"
    "checkout" : "2021-06-10"
     }
"additionalneeds" : "wi-fi"
}
**********************************************
Response Body
{
"bookingid":24,
"booking":
    {
    "firstname" : "Ahmet"
    "lastname" : “Bulut"
    "totalprice" : 500
    "depositpaid" : false
    "bookingdates" : {
        "checkin" : "2021-06-01"
        "checkout" : "2021-06-10"
         }
    "additionalneeds" : "wi-fi"
    }
}
     */

    @Test
    public void post01(){
        //1.Aşama:
       specHerokuapp.pathParam("pp1", "booking");

        TestDataHerokuApp testDataHerokuApp=new TestDataHerokuApp();
        JSONObject reqBody =testDataHerokuApp.bookingJsonObjOlustur();

       //2.Aşama:
        JSONObject expData= testDataHerokuApp.expectedDataJsonObjOlustur();

        //3.Aşama:

        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON)
                .when().body(reqBody.toString()).post("/{pp1}");
      //  response.prettyPrint();

        //4.Aşama:

    }

}