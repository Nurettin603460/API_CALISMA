package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.JsonPlaceRequestBodyPOJO;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class C25_Put_PojoClass  extends JsonPlaceHolderBaseUrl {
  /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
     body’e sahip bir PUT request yolladigimizda donen response’in
     response body’sinin asagida verilen ile ayni oldugunu test ediniz

     Request Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }

    Expected Body

    {
    "title":"Ahmet",
    "body":"Merhaba",
    "userId":10,
    "id":70
    }
     */


    @Test
    public void put01(){
        //1.Aşama: Endpoint ve Request Body hazirla.(3p)
    specJsonPlace.pathParams("pp1","posts","pp2",70);

    //Request Body için POJO clasından bir obje oluşturuyoruz. Parametreleri yazıyoru. dinamik yapmış oluyoruz. Java objesi olarak oluşturmuş oluyoruz.
        //Yani burada constructor call yapmış oluyoruz.
        JsonPlaceRequestBodyPOJO reqBody=new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);
        System.out.println("reqBody= " + reqBody);


        //2.aşama: Expected data hazırla: ReqBody ile aynı kalıba sahip olduğu için yukardakini kopyala yapıştır yap, ismini expBody yaz:
        JsonPlaceRequestBodyPOJO expBody=new JsonPlaceRequestBodyPOJO("Ahmet","Merhaba",10,70);

        //3.Aşama: Response oluştur ve kaydet:
        Response response=given()
                            .spec(specJsonPlace)
                            .contentType(ContentType.JSON)
                          .when()
                            .body(reqBody) //toString eklemiyoruz. Çünkü reqBody zaten bir java objesidir. POJO(Plain Old Java Object)
                            .put("/{pp1}/{pp2}");
        response.prettyPrint();

        //4.Aşama: Assertion: Setter ve Getter.lar kullanılacak. Ama öncesinde yapılması gerekenler var:
        // Önceki öğrendiklerimiz:
        //   response.jsonPath(); --> JsonPath.e dönüştürme ve atama: başına JSonPath respJsonPath = ...
        //   response.as(HashMap.class); --> Map.e dönüştürme ve atama: başına HashMap<String, Object> respMap=...
        //   Şimdi de aynı mantığı uygulacayacağız:

        response.as(JsonPlaceRequestBodyPOJO.class); // POJO class.nın kalıbına dökülmüş oldu.
        // Atama işlemi için ise JsonPlaceRequestBodyPOJO objesi oluşturup isim verip kaydedeceğiz:
        JsonPlaceRequestBodyPOJO respPOJO=response.as(JsonPlaceRequestBodyPOJO.class); //Benim yorumum: toString.le alakalı olabilir.
        // response işlemleri için pomxml.e birşeyler eklemeye gerek yok. çünkü herşey tamamen java objeleri üzerinden yapılmıştır. Serialize da yapmıyoruz, kalıp oluşturuyoruz.

        Assert.assertEquals(   expBody.getTitle() , respPOJO.getTitle() );
        Assert.assertEquals(   expBody.getBody() , respPOJO.getBody() );
        Assert.assertEquals(   expBody.getUserId() , respPOJO.getUserId() );
        Assert.assertEquals(   expBody.getId() , respPOJO.getId() );


    }
}
