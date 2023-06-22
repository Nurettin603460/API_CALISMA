package test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C10_Get_ResponseBodyTestiListKullanimi {

    @Test
    public void get01(){

    //1.Aşama: Endpoint hazırla, ihtiyaç varsa request body hazırla(3p)
    String url="https://dummy.restapiexample.com/api/v1/employees";

    //2.Aşama: Expected data hazırla.

    //3.Aşama: Response objesi oluştur ve dönen bilgileri kaydet.
        Response response=given()
                                .contentType(ContentType.JSON)
                          .when()
                                .get(url);

      response.prettyPrint();


    //4. Aşama:Assertion:

        response
                .then()
                        .assertThat()
                        .statusCode(200)
                        .contentType("application/json")
                        .body("data.id",hasSize(24),
                                "data.employee_name",hasItem("Ashton Cox"),
                                "data.employee_age", hasItems(61,40,30));





    }

}
