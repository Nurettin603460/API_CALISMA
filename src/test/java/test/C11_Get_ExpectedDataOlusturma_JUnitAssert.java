package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C11_Get_ExpectedDataOlusturma_JUnitAssert {
    @Test
    public void get(){
        //1.Aşama: Endpoint hazırla. ihtiyaç varsa request body hazırla(3p)
        String url="https://jsonplaceholder.typicode.com/posts/22";

        //2.Aşama: Expected Data Hazırla:
        JSONObject expData=new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","aaaaaaaaa");

        System.out.println("Expected Data: " + expData);

        // 3.aşama: Response oluştur ve kaydet:
        Response response=given()
                                .contentType(ContentType.JSON)
                                .when()
                                .get(url);
            response.prettyPeek(); // Response ile ilgili tüm detaylı bilgileri döndürür

        /*4.aşama: Assertion: Expected data ile response karşılaştırma: (JUnit Assert kullanımı)
                    NOT: Önceki assertion.lar key-value şeklinde idi. Value yazılıyordu ama burada sadece key üzerinden  assertion yapılacaktır. (dinamik hale getirilecektir)
                        O yüzden matchers kullanılmayacaktır.

             Expected data.daki verilere (JSonObject) expData.get("userId") şeklinde (JSonPath ile) direkt ulaşılabilir.
                Ama response.daki verilere ulaşmak için response üzerinden JsonPath objesi oluşturup bu obje üzerinden responseJSonPath.get("userId") şeklinde ulaşılabilir. */

          // response.daki verilere ulaşmak için JsonPath dataType.ında obje oluştur:
        JsonPath responseJsonPath=response.jsonPath();

        Assert.assertEquals(expData.get("userId"),responseJsonPath.get("userId"));
        Assert.assertEquals(expData.get("id"), responseJsonPath.get("id"));
        Assert.assertEquals(expData.get("title"), responseJsonPath.get("title"));

        // Not: expected için expectedData (JsonObject) olarak hazırladığımız JSONObject yolu kullanılır,
        //      actual için ise JsonPath.e dönüştürdüğümüz responseJasonPath üzerinde JSONPath yolu kullanılır.






    }

}
