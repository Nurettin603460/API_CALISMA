package test;

import org.json.JSONObject;
import org.junit.Test;

public class C09_Post_JsonPathBodyTesti {

    @Test
    public void post01(){
        //1.Aşama: Endpoint hazırla. ihtiyaç varsa request body hazırla(3p):
        String url="https://restful-booker.herokuapp.com/booking";

        JSONObject innerBody=new JSONObject();
        innerBody.put("checkin","2021-06-01");
        innerBody.put("checkout","2021-06-10");

        JSONObject reqBody= new JSONObject();
        reqBody.put("firstname","Ali");
        reqBody.put("lastname","Bak");
        reqBody.put("totalprice","500");
        reqBody.put("depositpaid","false");
        reqBody.put("bookingdates",innerBody);
        reqBody.put("additionalneeds","wifi");




    }
}
