package restapi.test.automation;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.json.simple.*;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.delete;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
 
import static org.hamcrest.Matchers.hasItems;

import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestCase_Tiger extends InitCase{
	
	final Logger jlog = LoggerInit.getLog(TestCase_Tiger.class);
	
	
	
	
	@BeforeClass
    public void initParams()
	{
		setup();
		//update value ,remove 1 in the top
		decode();
	}
	

   
	
	@Test
	public void GetwithAuth_NewModel() {		

		
		
		given().
		auth().basic(this.GETUSERNAME,this.GETPASSWORD).
		when().get(this.GETURL).
		then().body("name", equalTo("Latin America"))	
		.statusCode(200);

	}
	
	@Test
	public void GetwithAuth()
	{
		String URL = this.GETURL;	
		
		PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
		authScheme.setUserName(this.GETUSERNAME);
		authScheme.setPassword(this.GETPASSWORD);
		RestAssured.authentication = authScheme;			
		Response response = get(URL);
		jlog.info(response);
		System.out.println(response.asString());
 
	}
	
	@Test
	public void GetwithAuthAndParamInput_NewModel()
	{
		
		String URL = this.GETURL_PARAM;
		String jsonAsString ;
        Response response =
    	given()
        .auth().basic(this.GETUSERNAME,this.GETPASSWORD)
        .header(this.Header, "test@test.com")//change to real index
        .contentType("application/json")    
        .queryParam("subscriptionId","512668931")               
        .when().get(URL).then()   
        .contentType(ContentType.JSON)
        .extract().response();
        
        jsonAsString = response.asString();
        System.out.println(jsonAsString);
        jlog.info(response);
 
	}
	
	@Test
	public void GetwithAuthAndParamInput()
	{
		String URL = this.GETURL_PARAM;
		
		RestAssured.baseURI =URL;
		RequestSpecification request = RestAssured.given();
		
		request.header("Content-Type", "application/json");
		request.header(this.Header, "test@test.com");//change to real index
		request.auth().basic(this.GETUSERNAME,this.GETPASSWORD);
		request.queryParam("subscriptionId","512668931");		 
	    
		Response response = request.get(URL);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		jlog.info(response);
        int statusCode = response.getStatusCode();
        
        //Assert.assertEquals(statusCode, "201");
        String successCode = response.jsonPath().get("SuccessCode");
        //Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
 
	}
	
	@Test
	//https://jsoneditoronline.org/ change json view
	public void GetwithAuthAndPost()
	{
		String URL = this.POSTURL;		
		
		RestAssured.baseURI =URL;
		RequestSpecification request = RestAssured.given();	

		File file = new File("D:\\workspace\\RestApiTAuto\\t1.json");
		
		request.header("Content-Type", "application/json");
		request.header(this.Header, "test@test.com");
		request.auth().basic(this.POSTUSERNAME,this.POSTPASSWORD);
		request.body(file);
		 
	    
		Response response = request.post(URL);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		jlog.info(response);
        //int statusCode = response.getStatusCode();
        
        //Assert.assertEquals(statusCode, "201");
        //String successCode = response.jsonPath().get("SuccessCode");
        //Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
 
	}
	
	private JSONObject BuildJson()
	{
		JSONObject jo = new JSONObject();
		Collection<JSONObject> items = new ArrayList<JSONObject>(); 
		
		JSONObject item1 = new JSONObject();
	    item1.put("key", "name");
	    item1.put("value", "CECSAUTO");
	    items.add(item1);
	    
		JSONObject item2 = new JSONObject();
	    item2.put("key", "category");
	    item2.put("value", "OrderProcessingInfo");
	    items.add(item2);
	    
		JSONObject item3 = new JSONObject();
	    item3.put("key", "property_name");
	    item3.put("value", "allow_refresh_entitlement");
	    items.add(item3);	    

		
		JSONObject item4 = new JSONObject();
	    item4.put("key", "property_value");
	    item4.put("value", "N");
	    items.add(item4);	    
		 
		jo.put("name", "modify_service_properties");
		jo.put("options", items);
		System.out.println(jo.toString());
		return jo;
	}
	
	
	@Test
	//https://jsoneditoronline.org/ change json view
	public void GetwithAuthAndPost_JSONObject()
	{
		String URL = this.POSTURL;		
		
		RestAssured.baseURI =URL;
		RequestSpecification request = RestAssured.given();		
		
		JSONObject jo = BuildJson();			

		request.header("Content-Type", "application/json");
		request.header(this.Header, "test@test.com");
		request.auth().basic(this.POSTUSERNAME,this.POSTPASSWORD);
		request.body(jo);		 
	    
		Response response = request.post(URL);
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		jlog.info(response);
        //int statusCode = response.getStatusCode();
        
        //Assert.assertEquals(statusCode, "201");
       // String successCode = response.jsonPath().get("SuccessCode");
        //Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
 
	}

}
