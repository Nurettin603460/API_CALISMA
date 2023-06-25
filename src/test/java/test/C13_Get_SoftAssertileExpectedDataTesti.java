package test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static io.restassured.RestAssured.given;

// NOT: SoftAssert kullancacağımız için önce POM'a testNG eklenmeli.
// NOT: @Test Annotion TestNG.den gelmeli. o yüzden yukarda Junit.ten gelen Junit.Test importunu sil, aşağıda
        // kırmızıya dönen @Test üzerine gel, import class diyerek TestNG.den import et.

public class C13_Get_SoftAssertileExpectedDataTesti {
    @Test
    public void get01(){

        // 1.Aşama: Endpoint oluştur. ihtiyaç varsa request body oluştur.(put, post, patch)

        String url="http://dummy.restapiexample.com/api/v1/employee/3";

        //2.aşama: Expected Data oluştur
        JSONObject data = new JSONObject();
        data.put("id",3);
        data.put("employee_name","Ashton Cox");
        data.put("employee_salary",86000);
        data.put("employee_age",66);
        data.put("profile_image","");

        JSONObject expData=new JSONObject();
        expData.put("status","success");
        expData.put("data",data);
        expData.put("message","Successfully! Record has been fetched.");

        System.out.println("ExpectedData=" + expData);


        //3.aşama: Response oluştur ve kaydet:

        Response response=given().when().get(url);
        response.prettyPrint();

        //4.aşama: SoftAssert ile assertion:

        //Not: Assertion için response --> JSONPath.e dönüştürülmeli.
        //UYARI 1: assertion testNG ile olacağından pom.a testNG eklendi.
        //UYARI 2: assertion sıralaması Junit.tekinin tersidir: önce actualData, sonra expectedData yazılır

        JsonPath responseJsonPath=response.jsonPath();

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(responseJsonPath.get("status"),expData.get("status"), "status not EQUAL");
        softAssert.assertEquals(responseJsonPath.get("data.id"),expData.getJSONObject("data").get("id"), "id not EQUAL");
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"), expData.getJSONObject("data").get("employee_name"), "name not EQUAL");


        softAssert.assertEquals(responseJsonPath.get("message"), expData.get("message"),"Message not EQUAL");





        softAssert.assertAll();
    }
}
