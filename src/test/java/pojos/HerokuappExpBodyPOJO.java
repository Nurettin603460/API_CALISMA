package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //getter, setter ve toString.i oluşturuyor
@NoArgsConstructor // parametresiz constructor oluşturmak için
@AllArgsConstructor // tüm parametreleri içeren constructor oluşturmak için

public class HerokuappExpBodyPOJO {
  /*
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

private int bookingid;
private BookingPOJO booking;


}
