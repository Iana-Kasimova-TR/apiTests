package com.epam.project.tests;

import com.epam.project.model.User;
import com.epam.project.model.gist.File;
import com.epam.project.model.gist.Gist;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;


/**
 * rest test
 */
public class RestTemplateTests {
    RestTemplate restTempl;

    @BeforeTest
    public void setup(){
       restTempl = new RestTemplate();
    }

     @Test
    public void checkStatusCode(){
         ResponseEntity<User[]> response = restTempl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
         int actualResponseCode = response.getStatusCodeValue();
         Assert.assertEquals(actualResponseCode, 200, "Actual response code not valid");

     }


     @Test
    public void checkValueOfContentType(){
         ResponseEntity<User[]> response = restTempl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
         MediaType contentType = response.getHeaders().getContentType();
         Assert.assertNotEquals(contentType, null, "content type doesn't exist in response");
         Assert.assertEquals(contentType.getCharset().toString(), "UTF-8", "charset in content-type doesn't equal utf-8");
         Assert.assertEquals(contentType.getType(), "application", "value of contet type doesn't correct");
         Assert.assertEquals(contentType.getSubtype(), "json", "value of contet type doesn't correct");

     }

     @Test
     public void checkBodyOfresponse(){
         ResponseEntity<User[]> response = restTempl.getForEntity("https://jsonplaceholder.typicode.com/users", User[].class);
         Assert.assertEquals(response.getBody().length, 10, "number of value doesn't equals 10");
     }

     @Test
    public void checkPostQuery(){
         File file = new File("hello!");
         Map<String, File> files = new HashMap<String, File>();
         files.put("file1.txt", file);
         Gist gist = new Gist("yay!", true, files);

         HttpEntity<Gist> entity = new HttpEntity<Gist>(gist);
         ResponseEntity<Gist> response = restTempl.postForEntity("https://api.github.com/gists", entity, Gist.class);
         Assert.assertEquals(response.getStatusCode(), HttpStatus.CREATED);
         System.out.println(response.getHeaders().getLocation());
     }

     @Test
     public void checkPutQuery(){
         HttpHeaders requestHeaders = new HttpHeaders();
         requestHeaders.setContentLength(0);
         HttpEntity<Gist> entity = new HttpEntity<Gist>(requestHeaders);

        ResponseEntity<Gist>  response = restTempl.exchange("https://api.github.com/gists/9f5d3732772148fe3260e7794513f590/star", HttpMethod.PUT, entity, Gist.class);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);

     }

     @Test
    public void checkDeleteQuery(){
         HttpHeaders requestHeaders = new HttpHeaders();
         HttpEntity<Gist> entity = new HttpEntity<Gist>(requestHeaders);

         ResponseEntity<Gist>  response = restTempl.exchange("https://api.github.com/gists/9f5d3732772148fe3260e7794513f590", HttpMethod.DELETE, new HttpEntity<Gist>(requestHeaders), Gist.class);
         Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
     }


     @Test
    public void checkPatchQuery(){
         restTempl.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
         File file = new File("Yaaaaay!");
         Map<String, File> files = new HashMap<String, File>();
         files.put("file3.txt", file);
         Gist gist = new Gist("yay!", true, files);

         HttpEntity<Gist> entity = new HttpEntity<Gist>(gist);
         ResponseEntity<Gist>  response = restTempl.exchange("https://api.github.com/gists/9f5d3732772148fe3260e7794513f590", HttpMethod.PATCH, new HttpEntity<Gist>(gist), Gist.class);
         Assert.assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
     }
}
