package com.epam.project.tests;

import com.epam.project.model.User;
import com.google.gson.Gson;
import org.apache.commons.io.IOUtils;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Created by Iana_Kasimova on 14-Feb-18.
 */
public class HttpClientTests {

    @Test
    public void checkstatusCodeTest() throws ClientProtocolException, IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/users");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        int actualStatusCode = response.getStatusLine().getStatusCode();
        Assert.assertEquals(actualStatusCode, 200, "query doesn't response with code 200");
    }

    @Test
    public void checkContentValueTest() throws ClientProtocolException, IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/users");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        Header[] headers =  response.getHeaders("Content-type");
        Assert.assertEquals(headers[0].getValue(), "application/json; charset=utf-8", "value of content type doesn't equals application/json; charset=utf-8");
    }

    @Test
    public void checkresponseBody() throws ClientProtocolException, IOException{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://jsonplaceholder.typicode.com/users");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        Gson gson = new Gson();
        InputStream source = response.getEntity().getContent();
        Reader reader = new InputStreamReader(source);

        User[] users = gson.fromJson(reader, User[].class);

        Assert.assertEquals(users.length, 10, "number of users doesn't equals 10");



    }

}
