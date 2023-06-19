package test;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_Get_APISorgulama {

@Test
    public void get01(){

    String url="https://restful-booker.herokuapp.com/booking/10";

    Response response =given().when().get(url);

    response.prettyPrint(); //Test bittikten sonra yoruma al

    System.out.println("Status code: "+ response.getStatusCode());

    System.out.println("Content Type :"+ response.getContentType());

    System.out.println("Server Header Değeri: " + response.getHeader("Server"));

    System.out.println("Status Line :"+ response.getStatusLine());

    System.out.println("Response Time: "+ response.getTime());



}


}
