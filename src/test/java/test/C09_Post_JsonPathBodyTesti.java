package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class C09_Post_JsonPathBodyTesti {

    @Test
    public void post01(){
        //1.Aşama: Endpoint hazırla. ihtiyaç varsa request body hazırla(3p):
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject bookingdates=new JSONObject();
        bookingdates.put("checkin","2021-06-01");
        bookingdates.put("checkout","2021-06-10");

        JSONObject reqBody= new JSONObject();
        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice","500");
        reqBody.put("depositpaid",false);
        reqBody.put("bookingdates",bookingdates);
        reqBody.put("additionalneeds","wifi");

        System.out.println("Request Body :"+ reqBody);

        // 2.aşama: Expected Data Hazırla:

        // 3.Aşama: Response kaydet
        Response response=given().contentType(ContentType.JSON)
                .when().body(reqBody.toString())
                .post(url);

        response.prettyPrint();

        //4. Aşama: Assertion:

        response.then().
                    assertThat()
                    .statusCode(200)
                    .contentType("application/json; charset=utf-8")
                .body("booking.firstname", equalTo("Ali"))
                .body("booking.lastname",equalTo("Bak"))
                .body("booking.totalprice",equalTo(500))
                .body("booking.depositpaid",equalTo(false))
                .body("booking.bookingdates.checkin", equalTo("2021-06-01"))
                .body("booking.bookingdates.checkout",equalTo("2021-06-10"));

       //  Not: JSonPath yönteminde body.deki valule.lara ulaşmak için. (nokta) kullanılır.
        // JSonObject yönteminde ise dıştan içe getJSONArray --> getJSONObject (index) --> get(key) yolu kullanılır.


    }
}
