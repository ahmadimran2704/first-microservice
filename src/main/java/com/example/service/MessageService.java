package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class MessageService {

    @Autowired
    private RestTemplate restTemplate;

    public String callService() {
        final String url="http://localhost:9092/api/v1/get-message";
        URI uri= null;
        try {
            uri = new URI(url);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String response=(String) restTemplate.getForObject(uri,String.class);
        return response;
    }
}
