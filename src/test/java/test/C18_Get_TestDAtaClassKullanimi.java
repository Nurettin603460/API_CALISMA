package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlace;

import static io.restassured.RestAssured.given;

public class C18_Get_TestDAtaClassKullanimi extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/22 url'ine bir GET request yolladigimizda
    donen response’in status kodunun 200 ve response body’sinin asagida verilen ile ayni oldugunutest ediniz
    Response body :
{
"userId": 3
"id": 22
"title": "dolor sint quo a velit explicabo quia nam"
"body": body"::"eos qui et ipsum ipsam suscipit aut nsed omnis non odio nexpedita earummollitia
        molestiae aut atque rem suscipit nnam impedit esse"
}
    */

@Test
    public void get01(){

    //1.Aşama:Endpoint oluştur. ihtiyaç varsa (3p) request body hazırla.
    specJsonPlace.pathParams("pp1","posts","pp2",22);

    //2.Aşama: Expected Data oluştur (Expected Data=Response Body)
    // JsonObject.i TestData Package.nın içinde bir metoda yazdık. Bu class.taki metoda ulaşmak için extends kullanmayız.
       // çünkü extends.i içinde bulunduğumuz class.ta kullandık. Geriye obje oluşturma yöntemi kalıyor:

    TestDataJsonPlace testDataJsonPlace = new TestDataJsonPlace(); // TestDataJsonPlace clasından bir obje oluşturduk
    testDataJsonPlace.expectedJsonBodyOlustur();   // oluşturulan bu obje üzerinden TestDataJsonPlace class.ındaki metodu çağırdık.
        // ancak bu metodu çağırmak yeterli değil, metodun özelliklerini kullanabilmek için bunu bir değişkene atamak lazım:

    JSONObject expData2=testDataJsonPlace.expectedJsonBodyOlustur();


    // 3.Aşama: Response oluştur ve kaydet:
    Response response=given().spec(specJsonPlace).when().put("/{pp1}/{pp2}");
        response.prettyPrint();

    //4.Aşama: Assertion: //JUnit ile:

    Assert.assertEquals(testDataJsonPlace.basariliStatusCode, response.getStatusCode());

    JsonPath respJsonPath=response.jsonPath();
    Assert.assertEquals(expData2.get("userId"),respJsonPath.get("userId"));
    Assert.assertEquals(expData2.get("id"), respJsonPath.get("id"));
    Assert.assertEquals(expData2.get("title"), respJsonPath.get("title"));
    Assert.assertEquals(expData2.get("body"),respJsonPath.get("body"));












}



}
