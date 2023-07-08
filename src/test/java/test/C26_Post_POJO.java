package test;

import baseUrl.Herokuapp_BaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.BookingDatesPOJO;
import pojos.BookingPOJO;
import pojos.HerokuappExpBodyPOJO;
import pojos.JsonPlaceRequestBodyPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class C26_Post_POJO extends Herokuapp_BaseUrl {
 /*
    https://restful-booker.herokuapp.com/booking url’ine
    asagidaki body'ye sahip bir POST request gonderdigimizde
    donen response’un id disinda asagidaki gibi oldugunu test edin.
    	                Request body
    	           {
    	                "firstname" : "Ali",
    	                "lastname" : “Bak",
    	                "totalprice" : 500,
    	                "depositpaid" : false,
    	                "bookingdates" : {
    	                         "checkin" : "2021-06-01",
    	                         "checkout" : "2021-06-10"
    	                                  },
    	                "additionalneeds" : "wi-fi"
    	            }


    	            	Response Body = Expected Data
    	            	{
                    "bookingid":24,
                    "booking":{
                        "firstname":"Ali",
                        "lastname":"Bak",
                        "totalprice":500,
                        "depositpaid":false,
                        "bookingdates":{
                            "checkin":"2021-06-01",
                            "checkout":"2021-06-10"
                                        }
                        ,
                        "additionalneeds":"wi-fi"
                              }
                    }
         */

// Testimizi POJO ile hazırlayacağız. POJO sayesinde sadece variable.ları yazacağız. geri kalanını POJO otomatik yapacak:
    // bunun için;
    //1. Pojos package.ında body.nin her inner.ı için class oluşturuyoruz. Bu test için bookingdates, booking ve expBody olacak şekilde 3 tane class oluşturuyoruz.
    //   Class oluştururken class üstüne "lombok"tan gelen notasyonları eklemeyi unutma.


    @Test
    public void post01() {
        //1.Aşama: Endpoind ve ReqBody hazırla:
        specHerokuapp.pathParams("pp1","booking");
        // ReqBody.yi oluşturalım:
            // BookingPOJO reqBody=new BookingPOJO("Ali", "Bak",500,false, BookingDatesPOJO,"wi-fi");
                // bu şekilde yazdığımızda BookingDatesPOJO.nun altını kırmızı çizecektir. Önce inner olan BookingDatesPOJO.nun içini doldurmamız lazım:

        BookingDatesPOJO bookingdates=new BookingDatesPOJO("2021-06-01","2021-06-10");
        // şimdi bir üstteki satırı kopyala yapıştır yaptığımızda kızarıklık gitmiş olacaktır:

        BookingPOJO reqBody=new BookingPOJO("Ali", "Bak",500,false, bookingdates,"wi-fi");

        //2.Aşama: Expected Body hazırla: ExpBody=Response body:

        HerokuappExpBodyPOJO expBody = new HerokuappExpBodyPOJO(2377,reqBody);
        System.out.println("ExpectedBody= " +expBody);

        // 3.Aşama: REsponse oluştur ve kaydet:
        Response response=given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(reqBody).post("/{pp1}");
        response.prettyPrint();

        //4.Aşama: Assert:
        HerokuappExpBodyPOJO respPOJO= response.as(HerokuappExpBodyPOJO.class);
       // assertEquals(expBody.getBookingid(), respPOJO.getBookingid());
        assertEquals(expBody.getBooking().getFirstname(),respPOJO.getBooking().getFirstname());
        assertEquals(expBody.getBooking().getLastname(), respPOJO.getBooking().getLastname());
        assertEquals(expBody.getBooking().getTotalprice(), respPOJO.getBooking().getTotalprice());
        assertEquals(expBody.getBooking().isDepositpaid(), respPOJO.getBooking().isDepositpaid()); // Burada get ile depositpaid getirilemez.Çünkü
            // type.ı boolean olduğu için.(primitive data type). get ile getirmek istiyorsak dataType olarak Boolean yapmamız lazım.








    }



}
