package test;

public class C21_PostTestDataKullanimi {

    /*
    https://restfulbooker.herokuapp.com/booking url’ine asagidaki body'ye sahip bir POST
request gonderdigimizde donen response’un id haric asagidaki gibi oldugunu test edin.

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


}
