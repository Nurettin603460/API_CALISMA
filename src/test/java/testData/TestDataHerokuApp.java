package testData;
import org.json.JSONObject;
import org.junit.Test;

public class TestDataHerokuApp {

    public int basariliStatusCode=200;
public JSONObject bookingdatesJsonObjOlustur(){
    JSONObject boookingdates=new JSONObject();
    boookingdates.put("checkin","2021-06-01");
    boookingdates.put("checkin","2021-06-10");

    return boookingdates;
}



public JSONObject bookingJsonObjOlustur(){
        JSONObject booking=new JSONObject();
        booking.put("firstname","Ahmet");
        booking.put("lastname","Bulut");
        booking.put("totalprice",500);
        booking.put("depositpaid",false);
        booking.put("bookingdates",bookingdatesJsonObjOlustur());
        booking.put("additionalneeds","wi-fi");

        return booking;
    }

    public JSONObject expectedDataJsonObjOlustur(){
        JSONObject expData=new JSONObject();
        expData.put("bookingId",24);
        expData.put("booking", bookingJsonObjOlustur());

        return expData;

    }


}
