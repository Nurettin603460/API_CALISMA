package pojos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Class.ın üstüne aşağıdaki notasyonları yaz. Bu notasyonlar org.projectlombok.tan gelmektedir. (pom.xml.e eklendi) POJO.yu otomatik oluşturmak için.
@Data //getter, setter ve toString.i oluşturuyor
@NoArgsConstructor // parametresiz constructor oluşturmak için
@AllArgsConstructor // tüm parametreleri içeren constructor oluşturmak için

public class BookingDatesPOJO {
/*          {
            "checkin" : "2021-06-01",
            "checkout" : "2021-06-10"
            }
*/
    // Variable.ları elle yazıyoruz:

    private String checkin;
    private String checkout;








}
