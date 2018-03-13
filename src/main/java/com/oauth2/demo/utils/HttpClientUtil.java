package com.oauth2.demo.utils;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * Created by srujant on 11/7/17.
 */
public class HttpClientUtil {
    private static final HttpClient httpClient = HttpClientBuilder.create().build();

    public static HttpResponse executeGet(HttpGet httpGet){
        try {
            return httpClient.execute(httpGet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static HttpResponse executePost(HttpPost httpPost){
        try {
            return httpClient.execute(httpPost);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
