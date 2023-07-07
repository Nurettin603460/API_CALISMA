package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestapi_BaseUrl {

   protected RequestSpecification specDummyRestapi;

    @Before
    public void setUp(){
        specDummyRestapi=new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com").build();
    }
}
