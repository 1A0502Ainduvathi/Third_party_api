package com.test2.example.test2.service;

import com.test2.example.test2.Repository.UrlRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test2.example.test2.model.ApiResponse;
import com.test2.example.test2.model.Url;
//import com.test2.example.test2.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
@Service
public class UrlService {
    private final RestTemplate restTemplate;
   // private final String uri="https://reqres.in/api/users/1";
    private final String urii="https://reqres.in/api/users";
    private UrlRepository repo;
    @Autowired
    public UrlService(RestTemplate restTemplate,UrlRepository repo) {
        this.restTemplate = restTemplate;
        this.repo=repo;
    }


    /*public String saveAllObject() {
        // TODO Auto-generated method stub
        Gson gson =new Gson();
        String check= restTemplate.getForObject(uri,String.class);
        Url url=gson.fromJson(check,Url.class);
        //System.out.println("ID:"+url.getData().getId());
       // System.out.println("email:"+url.getData().getEmail());
        //System.out.println(url.getSupport());
        System.out.println(check);
        repo.save(url);
        return check;
    }*/

    public List<Url> saveAllObjects() {
        // Fetch the data from the API
        String jsonResponse = restTemplate.getForObject(urii, String.class);

        // Parse the response using Gson
        Gson gson = new Gson();
        ApiResponse apiResponse = gson.fromJson(jsonResponse, ApiResponse.class);

        // Get the list of Url objects
        List<Url> urlList = apiResponse.getData();
        System.out.println(urlList);

        // Save all Url objects to the database
        return repo.saveAll(urlList);
    }
}

