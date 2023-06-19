package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JSONObjesiOlusturma {


    @Test
            public void jsonObject01(){

        JSONObject jsonObject=new JSONObject();

        jsonObject.put("title","Ahmet");
        jsonObject.put("body", "Merhaba");
        jsonObject.put("userId", 4352);
        System.out.println(jsonObject);
    }

    @Test
    public void jsonObje02(){

        JSONObject innerBodyJson=new JSONObject();
        innerBodyJson.put("checkin","2018-01-01");
        innerBodyJson.put("checkout","1019-01-01");

        JSONObject bodyJson=new JSONObject();
        bodyJson.put("firstname","Jim");
        bodyJson.put("additionalneeds","Breakfast");
        bodyJson.put("bookingdates", innerBodyJson);
        bodyJson.put("","");
        bodyJson.put("","");
        bodyJson.put("","");

        System.out.println(bodyJson);

    }

}
