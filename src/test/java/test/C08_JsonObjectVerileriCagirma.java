package test;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C08_JsonObjectVerileriCagirma {

    @Test
    public void jsonObje01(){

        //1.aşama: içteki telefon bilgileri için Json objesi oluştur --Cep tel ve ev tel için ayrı oluştur:

        JSONObject cepTel=new JSONObject();
        cepTel.put("type","iphone");
        cepTel.put("number","0554-138-4992");

        JSONObject evTel=new JSONObject();
        evTel.put("type","home");
        evTel.put("number","0356-715-8205");

        // 2.aşama: Oluşturulan bu iki Json objesini bir Array.e koyacağız:

        JSONArray phoneNumbers =new JSONArray();
        phoneNumbers.put(0, cepTel);
        phoneNumbers.put(1,evTel);

        // *** Böylece phoneNumbers body.sindeki bilgiler oluşturulmuş oldu.


        //3.Aşama: ADRES BİLGİLERİ için Json objesi oluşturma:

        JSONObject address=new JSONObject();
        address.put("streetAddress", "naist street");
        address.put("city","Nara");
        address.put("postcode","60500");

        //4.Aşama: Geriye baştan itibaren body.yi oluşturmak kaldı:

        JSONObject bilgilerJson= new JSONObject();
        bilgilerJson.put("firstname","John");
        bilgilerJson.put("lastname","Doe");
        bilgilerJson.put("age","41");
        bilgilerJson.put("address",address);
        bilgilerJson.put("phoneNumbers", phoneNumbers);

        System.out.println(bilgilerJson);
        System.out.println(bilgilerJson.getJSONObject("address").get("city"));
        System.out.println(bilgilerJson.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));

    }
}
