package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class C15_BaseUrlJsonPlaceHolder extends JsonPlaceHolderBaseUrl {

    @Test
    public void get01(){
        /* https://jsonplaceholder.typicode.com /posts endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve
        Response’ta 100 kayit oldugunu test edin */

        // 1.Aşama: Endpoint hazırla.

                 // Endopoint olarak kullandığımız String url yerine önce base olan spec
                 // çağrılıyor, sonra pathParam olarak path parametreleri yazılır.
                 // Böylece endpoint url tanımlanmış olur, set edilmiş olur.
        specJsonPlace.pathParam("pp1", "posts");

        //2.Aşama: Expected Body hazırla.

        //3.Aşama: Response oluştur ve kaydet:
        // --> spec çağırıyoruz. spec.in içerisine daha önce oluşturduğumuz spec objesini
              // objesini koyuyoruz.
                Response response=given().spec(specJsonPlace).when().get("/{pp1}");
        response.prettyPrint();

        //4.Aşama: Assertion
        response
                .then()
                .assertThat()
                    .statusCode(200)
                .body("title", Matchers.hasSize(100));

    }
    @Test
    public void get02(){
        /*
        https://jsonplaceholder.typicode.com /posts/44 endpointine bir GET request
        gonderdigimizde donen response’un status code’unun 200 oldugunu ve “title”
        degerinin “optio dolor molestias sit” oldugunu test edin */

        //1.Aşama: Endpoint hazırla.
        specJsonPlace.pathParams("pp1","posts","pp2",44);

        //2.Aşama: Expected Data hazırla.

        //3.Aşama: Response oluştur ve kaydet.
        Response response=given().spec(specJsonPlace).when().get("/{pp1}/{pp2}");
        response.prettyPrint();

        //4.Aşama: Assert:
        response.then().assertThat().statusCode(200)
                .body("title", Matchers.equalTo("optio dolor molestias sit"));
;    }
    @Test
    public void delete01(){
       /* https://jsonplaceholder.typicode.com /posts/50 endpointine bir DELETE request
gonderdigimizde donen response’un status code’unun 200 oldugunu ve response
body’sinin null oldugunu test edin */

        //1. Aşama: Endpoint hazırla. ihtiyaç varsa request body hazırla.
        specJsonPlace.pathParams("pp1","posts","pp2","50");

        //2.Aşama: Expected Data Hazırla.

        //3.Aşama: Response body hazırla.
        Response response=given().spec(specJsonPlace).when().delete("{pp1}/{pp2}");
        response.prettyPrint();
        //4.Aşama: Assertion:
        response.then().assertThat().statusCode(200).body("title",Matchers.nullValue());
    }

}
