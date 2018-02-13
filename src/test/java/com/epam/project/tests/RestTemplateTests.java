package com.epam.project.tests;

import com.epam.project.model.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.Test;



/**
 * rest test
 */
public class RestTemplateTests {


     @Test
    public void checkStatusCode(){
         RestTemplate restTempl = new RestTemplate();
         ResponseEntity<User[]> response = restTempl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
         int actualResponseCode = response.getStatusCodeValue();
         Assert.assertEquals(actualResponseCode, 200, "Actual response code not valid");

     }


     @Test
    public void checkValueOfContentType(){
         RestTemplate restTempl = new RestTemplate();
         ResponseEntity<User[]> response = restTempl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
         MediaType contentType = response.getHeaders().getContentType();
         Assert.assertNotEquals(contentType, null, "content type doesn't exist in response");
         Assert.assertEquals(contentType.getCharset().toString(), "UTF-8", "charset in content-type doesn't equal utf-8");
         Assert.assertEquals(contentType.getType(), "application", "value of contet type doesn't correct");
         Assert.assertEquals(contentType.getSubtype(), "json", "value of contet type doesn't correct");

     }

     @Test
     public void checkBodyOfresponse(){
         RestTemplate restTempl = new RestTemplate();
         ResponseEntity<User[]> response = restTempl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
         Assert.assertEquals(response.getBody().length, 10, "number of value doesn't equals 10");
     }
}
