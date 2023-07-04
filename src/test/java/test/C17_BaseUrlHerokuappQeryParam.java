package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class C17_BaseUrlHerokuappQeryParam extends Herokuapp_BaseUrl {

    @Test
    public void get01(){
        /*https://restful booker.herokuapp.com/booking endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve Response’ta
        787 booking oldugunu test edin*/

        //1.Aşama: Endpoint hazırla. İhtiyaç varsa request body hazırla.
        specHerokuapp.pathParams("pp1","booking");

        //2.Aşama: Expected Body hazırla.

        //3.Aşama: Response oluştur ve kaydet:
        Response response= given().spec(specHerokuapp).when().get("/{pp1}");
        response.prettyPrint();

        //4.Aşama: Assertion:

       response.then().assertThat().statusCode(200).body("bookingid", Matchers.hasItem(787));

    }

    @Test
    public void get02(){
        /*https://restful booker.herokuapp.com/booking endpointine gerekli Query
parametrelerini yazarak “firstname” degeri “Eric” olan rezervasyon oldugunu test
edecek bir GET request gonderdigimizde, donen response’un status code’unun 200
oldugunu ve “Eric” ismine sahip en az bir booking oldugunu test edin*/

        //1.Aşama
        specHerokuapp.pathParams("pp1","booking").queryParam("firstname","Eric");

        //2.Aşama
        //3.Aşama
        Response response = given().spec(specHerokuapp).when().get("/{pp1}");
        response.prettyPrint();

        //4.aşama
         response.then().assertThat().statusCode(200).body("bookingid",Matchers.hasSize(2));
    }

}
