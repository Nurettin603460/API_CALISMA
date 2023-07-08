package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter ve toString.i oluşturuyor
@NoArgsConstructor // parametresiz constructor oluşturmak için
@AllArgsConstructor // tüm parametreleri içeren constructor oluşturmak için
public class BookingPOJO {

   /* {
        "firstname" : "Ali",
        "lastname" : “Bak",
        "totalprice" : 500,
        "depositpaid" : false,
        "bookingdates" : {
                "checkin" : "2021-06-01",
                "checkout" : "2021-06-10"
    },
        "additionalneeds" : "wi-fi"
    }*/

    private String firstname; // String bir class ismidir :)  Tıkla gör.
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private BookingDatesPOJO bookingdates; // bookingdates.i BookingDatesPOJO class.ından alıp geliyor :) DataType olarak class ismi yazıldı, String.te olduğu gibi.
    private String additionalneeds;

}