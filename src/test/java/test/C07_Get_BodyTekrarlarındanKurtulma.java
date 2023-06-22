package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C07_Get_BodyTekrarlarındanKurtulma {

    @Test
    public void get01(){

        //1. Url hazırla.
        String url="https://restful-booker.herokuapp.com/booking/10";

        //2.Expected Data Hazırla.
        //3. Response kaydet.

        Response response= given().when().get(url);
        response.prettyPrint();

        //4. Assertion:
      /* Matchers yazılı olarak:
        response
                .then()
                      .assertThat()
                      .statusCode(200)
                      .contentType("application/json;charset=utf-8")
                        .body("firstname",Matchers.equalTo("Mark"),
                                "lastname",Matchers.equalTo("Wilson"),
                                "totalprice",Matchers.equalTo(730),
                                "depositpaid", Matchers.equalTo("true"),
                                "depositpaid", Matchers.equalTo("true"),
                                "additionalneeds",Matchers.equalTo("Breakfast"));
        */
 // Matchers.ı sil, import static method.a tıkla. sonuç aşağıdaki gibi.
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json;charset=utf-8")
                .body("firstname",equalTo("Mark"),
                        "lastname", equalTo("Wilson"),
                        "totalprice", equalTo(730),
                        "depositpaid", equalTo("true"),
                        "depositpaid", equalTo("true"),
                        "additionalneeds", equalTo("Breakfast"));

    }

}
