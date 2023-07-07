package testData;
import java.util.HashMap;

public class TestDataDummyRestApi {

    public int statusCode=200;
    public String contentType="application/json";


//Not: Map.te sayıları double olarak yazıyoruz:
    public HashMap<String,Object> dataMapOlustur() {
        HashMap<String,Object> data = new HashMap<>();
        data.put("id", 3.0);
        data.put("employee_name", "Ashton Cox");
        data.put("employee_salary", 86000.0);
        data.put("employee_age", 66.0);
        data.put("profile_image", "");
        return data;
    }


    public HashMap<String, Object> expectedBodyMapOlustur() {

        HashMap<String, Object> expBody = new HashMap<>();
        expBody.put("status", "success");
        expBody.put("data", dataMapOlustur());
        expBody.put("message", "Successfully! Record has been fetched.");
        return expBody;
    }

}
