package testData;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Objects;

public class TestDataJsonPlace {

    public int basariliStatusCode=200;

    public JSONObject expectedJsonBodyOlustur(){
        JSONObject expData=new JSONObject();
        expData.put("userId",3);
        expData.put("id",22);
        expData.put("title","dolor sint quo a velit explicabo quia nam");
        expData.put("body","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");

        return expData;
    }
    public JSONObject requestJsonBodyOlustur(){

        JSONObject reqJsonObj=new JSONObject();
        reqJsonObj.put("title","Ahmet");
        reqJsonObj.put("body","Merhaba");
        reqJsonObj.put("userId",10);
        reqJsonObj.put("id",70);

        return reqJsonObj;
    }

    public HashMap requestBodyOlusturMap(){
       HashMap<String, Object> reqBody=new HashMap<>();
        reqBody.put("title","Ahmet");
        reqBody.put("body","Merhaba");
        reqBody.put("userId",10);
        reqBody.put("id",70);


        return reqBody;
    }

}
