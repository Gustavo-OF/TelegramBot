package com.service;


import com.model.Auth;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;

import java.io.IOException;

public class RequestService {

    private Gson gson;
    private HttpClient httpClient;
    public RequestService(){

        this.gson = new Gson();
        this.httpClient = HttpClientBuilder.create().build();
    }

    /**
     * Faz a requisição GET, passando a chave de acesso, e retorna a resposta do Body
     * @param url
     * @param authKey
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    protected String sendGET(String url, String authKey) throws IOException, InterruptedException {
        HttpGet request = new HttpGet(url);
        request.addHeader("content-type", "application/json");
        request.addHeader("Authorization", "Bearer "+authKey);
        HttpResponse response = this.httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity,"UTF-8");
    }


    protected String sendPOST(String url, Auth auth) throws IOException, InterruptedException {
        String paramsJson = gson.toJson(auth);
        HttpPost request = new HttpPost(url);
        StringEntity params = new StringEntity(paramsJson);
        request.addHeader("content-type", "application/json");
        request.setEntity(params);
        HttpResponse response = this.httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        return EntityUtils.toString(entity,"UTF-8");
    }

}
